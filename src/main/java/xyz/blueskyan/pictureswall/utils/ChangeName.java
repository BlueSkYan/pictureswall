package xyz.blueskyan.pictureswall.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class ChangeName {
    public static String setUuid(MultipartFile file){
        String flag = "empty";
        if (file.isEmpty()){
            return flag;
        }else {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
            return fileName;
        }
    }
}
