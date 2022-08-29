package xyz.blueskyan.pictureswall.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {
    public static void uploadFile(MultipartFile file, String path, String fileName) throws IOException {
        //确定上传的文件名
        String realPath = path + fileName;
        File dest = new File(realPath);
        file.transferTo(dest);
    }

}
