package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.security.entity.AuthentificationRequest;
import com.codingtech.formationcenter.security.entity.AuthentificationResponse;
import com.codingtech.formationcenter.security.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;







@RestController
@CrossOrigin("http://localhost:5174")
public class AuthentificationController {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsService custemUserDetailsService;


    @Autowired
    private jwtUtil jwtokenUtil;

	/*@GetMapping("/test22")
	public String test22()
	{
		return "Bonjour";
	}*/

    @RequestMapping(value="/login" ,method =RequestMethod.POST)
    public AuthentificationResponse authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
    {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            // TODO: handle exception
            throw new Exception("incorrect username ou password",e);
        }

        final UserDetails userdetails=custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
        final String jwt=jwtokenUtil.generateToken(userdetails);
        return new AuthentificationResponse(jwt, userdetails);
    }





}