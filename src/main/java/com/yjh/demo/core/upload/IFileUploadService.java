package com.yjh.demo.core.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by YJH on 2016/4/11.
 */
public interface IFileUploadService {
    UploadResult imgUpload(MultipartFile[] files);
}
