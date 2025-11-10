package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public String uploadImage(String path, MultipartFile image) throws IOException {
        //Here,    path = "images/";
//        File names of current / original file
        String originalFileName = image.getOriginalFilename();

        // Generate a unique file name (UUID)
        String randomId = UUID.randomUUID().toString(); //1234

        String imageName = randomId.concat(originalFileName.substring(originalFileName.indexOf('.')));
        //mat.jpg --> 1234 -->  1234.jpg

        String imagePath = path + File.separator + imageName;
        //(could have used - path + "/" + fileName - but it might not support in other Operating Sys. )

        // check if path exist and create
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }

        // upload to server
        Files.copy(image.getInputStream(), Paths.get(imagePath));


//        return file name
        return imageName;
    }

}
