package xyz.blueskyan.pictureswall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.blueskyan.pictureswall.entity.DataJson;
import xyz.blueskyan.pictureswall.entity.Picinfo;
import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.service.MinioFileService;
import xyz.blueskyan.pictureswall.service.PicinfoService;
import xyz.blueskyan.pictureswall.utils.ChangeName;
import xyz.blueskyan.pictureswall.utils.FileToMultipartFile;
import xyz.blueskyan.pictureswall.utils.PicCompression;


import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private PicinfoService picinfoService;

    @Autowired
    private MinioFileService minioFileService;

    @Value("${path.tempPath}")
    private String tempPath;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.bucketName2}")
    private String bucketName2;

    @RequestMapping("text")
    public String uplaodText(@RequestParam("title") String title, @RequestParam("description") String description,
                             @RequestParam("fullsVirtualPath") String fullsVirtualPath,
                             @RequestParam("thumbsVirtualPath") String thumbsVirtualPath, HttpSession session) throws IOException {
        Picinfo picInfo = new Picinfo();
        Date date = new Date();
        User user = (User) session.getAttribute("LoginUser");
        picInfo.setTitle(title);
        picInfo.setDescription(description);
        picInfo.setFullsLoc(fullsVirtualPath);
        picInfo.setThumbsLoc(thumbsVirtualPath);
        picInfo.setDatetime(date);
        picInfo.setRoleid(user.getRoleid());
        picinfoService.save(picInfo);
        return "redirect:/index";
    }

    @RequestMapping("image")
    @ResponseBody
    public DataJson uploadImage(@RequestParam(value = "file") MultipartFile file) throws IOException {
        String fileName = ChangeName.setUuid(file);
        minioFileService.uploadFile(file, bucketName, fileName);
        File newFile = new File(tempPath + fileName);
        PicCompression.PicCut(file, newFile);
        MultipartFile multipartFile = FileToMultipartFile.toMultipartFile(file, newFile);
        minioFileService.uploadFile(multipartFile, bucketName2, fileName);
        newFile.delete();
        String fullsUrl = endpoint + "/" + bucketName + "/" + fileName;
        String thumbsUrl = endpoint + "/" + bucketName2 + "/" + fileName;
        DataJson dataJson = new DataJson();
        if (!fileName.equals("empty")) {
            dataJson.setCode(1);
            dataJson.setMsg("上传成功");
            HashMap<String, String> map = new HashMap<>();
            map.put("fullsVirtualPath", fullsUrl);
            map.put("thumbsVirtualPath", thumbsUrl);
            dataJson.setData(map);
        } else {
            dataJson.setCode(0);
            dataJson.setMsg("上传失败");
        }
        return dataJson;
    }
}
