package com.sc.config;

import com.sc.Properties;
import com.sc.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Utils {

    public static Attachment saveFile(MultipartFile file, String folderName){

        if (file.isEmpty()) return null;

        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(Properties.WRITE_PATH, folderName, fileName).toString(); // for fixing all the slash direction


        File folder = new File(Properties.WRITE_PATH + folderName);

        if (!folder.exists()) folder.mkdirs();

        Path destinationFile = Paths.get(filePath);
        try{
            Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

            Attachment attachment = new Attachment();
            attachment.setAttachmentName(fileName);
            attachment.setAttachmentPath(filePath);
            attachment.setAttachmentType(file.getContentType()); // its define the file content type

            return attachment;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}