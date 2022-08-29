package xyz.blueskyan.pictureswall.utils;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileToMultipartFile {
    public static MultipartFile toMultipartFile(MultipartFile file, File newFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(newFile);
        MultipartFile multipartFile = new MockMultipartFile(newFile.getName(),file.getName(),file.getContentType(), inputStream);
        return multipartFile;
    }
}
