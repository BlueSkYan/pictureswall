package xyz.blueskyan.pictureswall.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class PicCompression {
    public static void PicCut(MultipartFile file, File newFile) throws IOException {
        Thumbnails.of(file.getInputStream()).size(1280,1280).outputQuality(0.3f).toFile(newFile);
    }
}
