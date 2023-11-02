package com.codingtech.formationcenter.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    private final String CLOUD_NAME = "dgqgv1xsg";
    private final String API_KET = "637188572651578";
    private final String API_SECRET  = "5_4D-3StRkGaSq8i5QVvD-pnhKE";

    @Bean
    public Cloudinary cloudinary() {
        Map<String,String> config = new HashMap<>();

        config.put("cloud_name",CLOUD_NAME);
        config.put("api_key",API_KET);
        config.put("api_secret",API_SECRET);

        return new Cloudinary(config);
    }


}

