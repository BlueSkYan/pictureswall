package xyz.blueskyan.pictureswall.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.blueskyan.pictureswall.service.MinioFileService;
import xyz.blueskyan.pictureswall.utils.MinioUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@Service
public class MinioFileServiceImpl implements MinioFileService {

    @Resource
    private MinioUtil minioUtil;


    @Override
    public void uploadFile(MultipartFile file, String bucketName, String fileName) throws IOException {
        if (!minioUtil.bucketExists(bucketName)){
            minioUtil.makeBucket(bucketName);
        }
        InputStream inputStream = file.getInputStream();
        minioUtil.upload(bucketName,fileName,file,inputStream);
        inputStream.close();
    }

    @Override
    public String getUrl(String fileName, String bucketName) {
        String url = minioUtil.preview(fileName,bucketName);
        return url;
    }

}
