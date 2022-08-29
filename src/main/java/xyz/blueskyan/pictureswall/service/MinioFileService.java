package xyz.blueskyan.pictureswall.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MinioFileService {
    void uploadFile(MultipartFile file, String bucketName,String fileName) throws IOException;

    String getUrl(String fileName, String bucketName);

}
