package com.yjh.demo.core.upload;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by YJH on 2016/4/11.
 */
public interface IFileUploadService {
    UploadResult imgUpload(MultipartFile[] files) throws IOException;

    File moveToImg(String picPath);

    void deleteImg(String picPath);

    boolean deleteFile(File file);

    File getMiniImgFile(String fileName);

    File getMediumImgFile(String fileName);

    String getHttpPath(String type);
}
