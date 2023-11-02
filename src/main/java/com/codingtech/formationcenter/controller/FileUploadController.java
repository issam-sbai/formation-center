package com.codingtech.formationcenter.controller;


import com.codingtech.formationcenter.service.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class FileUploadController {

    private final FileUpload fileUpload;

    @Autowired
    public FileUploadController(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            // Use the FileUpload service to upload the file to Cloudinary
            String fileUrl = fileUpload.uploadFile(file);
            return "File uploaded successfully. URL: " + fileUrl;
        } catch (IOException e) {
            return "File upload failed: " + e.getMessage();
        }
    }
}
