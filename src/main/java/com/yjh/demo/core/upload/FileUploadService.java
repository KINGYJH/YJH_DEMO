package com.yjh.demo.core.upload;

import com.yjh.demo.core.util.CoreStringUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by YJH on 2016/4/11.
 */
public class FileUploadService implements IFileUploadService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String DOT = ".";

    private FileUploadConfig fileUploadConfig;

    private ImgUploadConfig imgUploadConfig;

    public void setFileUploadConfig(FileUploadConfig fileUploadConfig) {
        this.fileUploadConfig = fileUploadConfig;
    }

    public void setImgUploadConfig(ImgUploadConfig imgUploadConfig) {
        this.imgUploadConfig = imgUploadConfig;
    }

    @Override
    public UploadResult imgUpload(MultipartFile[] files) throws IOException {
        List<Object> resultFiles = new ArrayList<Object>();
        File folder = new File(imgUploadConfig.getPath(), imgUploadConfig.getTemp());//创建工作目录
        folder.mkdirs();

        String url = imgUploadConfig.getDomainName() + imgUploadConfig.getTemp();
        for (MultipartFile file : files) {
            String message = null;
            if (file.isEmpty()) {
                message = "文件未上传";
                logger.info("文件未上传");
            }

            //返回客户端的文件系统中的原始文件名
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
            String type = (fileName.substring(fileName.lastIndexOf(DOT) + 1)).toLowerCase();
            //获取文件大小
            long fileSize = file.getSize();

            if (imgUploadConfig.getMaxSize() < fileSize) {
                message = "文件过大，无法上传！";
                logger.info("上传文件[{}]大小[{}]超过了[{}]", fileName, fileSize, fileUploadConfig.getMaxSize());
            }

            if (!imgUploadConfig.getType().contains(type)) {
                message = "文件类型错误！";
                logger.info("上传文件[{}]类型[{}]错误", fileName, type);
            }
            if (CoreStringUtils.isEmpty(message)) {
                String saveFileName = UUID.randomUUID().toString();
                //原图片
                File saveFile = new File(folder, CoreStringUtils.join(DOT, saveFileName, type));
                file.transferTo(saveFile);
                //小图片
                File miniThumbnailFile = new File(folder, CoreStringUtils.join(DOT,
                        imgUploadConfig.getMiniThumbnailWidth(), imgUploadConfig.getMiniThumbnailHeight(), saveFileName, type));
                InputStream is = new FileInputStream(saveFile);
                BufferedImage buff = ImageIO.read(is);
                int mediumWidth = buff.getWidth() / 2;   //得到图片的宽度
                int mediumHeight = buff.getHeight() / 2;  //得到图片的高度
                is.close(); //关闭Stream
                //适中图片
                File mediumThumbnailFile = new File(folder, CoreStringUtils.join(DOT, "medium", mediumWidth, mediumHeight, saveFileName, type));

                logger.info("上传文件[{}]成功", saveFile.getAbsolutePath());

                Thumbnails.of(saveFile)
                        .size(imgUploadConfig.getMiniThumbnailWidth(), imgUploadConfig.getMiniThumbnailHeight())
                        .keepAspectRatio(true)                 // 是否按比例缩放
                        .toFile(miniThumbnailFile);
                logger.info("生成迷你缩略图文件[{}]成功", miniThumbnailFile.getAbsolutePath());

                Thumbnails.of(saveFile)
                        .size(mediumWidth, mediumHeight)
                        .keepAspectRatio(true)
                        .toFile(mediumThumbnailFile);
                logger.info("生成适中缩略图文件[{}]成功", miniThumbnailFile.getAbsolutePath());

                resultFiles.add(new UploadSuccess(saveFile.getName(), fileSize,
                        url + saveFile.getName(),
                        CoreStringUtils.join(null, "/uploadFile/deleteTemp?fileName=", saveFile.getName())));
            } else {
                resultFiles.add(new UploadFailure(file.getOriginalFilename(), message));
            }
        }
        return new UploadResult(resultFiles.toArray());
    }

    /**
     * @param picPath 全路径图片地址
     * @return
     */
    @Override
    public File moveToImg(String picPath) {
        try {
            String fileName = picPath.split("/")[picPath.split("/").length - 1];
            File tempFolder = new File(imgUploadConfig.getPath(), imgUploadConfig.getTemp());
            File tempFile = new File(tempFolder, fileName);
            File miniTempFile = new File(tempFolder, CoreStringUtils.join(DOT,
                    imgUploadConfig.getMiniThumbnailWidth(), imgUploadConfig.getMiniThumbnailHeight(), fileName));
            InputStream is = new FileInputStream(tempFile);
            BufferedImage buff = ImageIO.read(is);
            int mediumWidth = buff.getWidth() / 2;   //得到图片的宽度
            int mediumHeight = buff.getHeight() / 2;  //得到图片的高度
            is.close(); //关闭Stream

            File mediumTempFile = new File(tempFolder, CoreStringUtils.join(DOT, "medium", mediumWidth, mediumHeight, fileName));

            if (!tempFile.exists() || !miniTempFile.exists() || !mediumTempFile.exists()) {
                logger.warn(fileName + "文件不存在。");
                return null;
            }

            File folder = new File(imgUploadConfig.getPath(), imgUploadConfig.getFolder());
            folder.mkdirs();
            File file = new File(folder, fileName);
            File miniFile = new File(folder, CoreStringUtils.join(DOT,
                    imgUploadConfig.getMiniThumbnailWidth(), imgUploadConfig.getMiniThumbnailHeight(), fileName));
            File mediumFile = new File(folder, CoreStringUtils.join(DOT, "medium", mediumWidth, mediumHeight, fileName));

            FileUtils.moveFile(tempFile, file);
            FileUtils.moveFile(miniTempFile, miniFile);
            FileUtils.moveFile(mediumTempFile, mediumFile);

            return file;
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * @param picPath 全路径图片地址
     */
    @Override
    public void deleteImg(String picPath) {
        try {
            String fileName = picPath.split("/")[picPath.split("/").length - 1];
            File folder = new File(imgUploadConfig.getPath(), imgUploadConfig.getFolder());
            File file = new File(folder, fileName);
            File miniFile = new File(folder, CoreStringUtils.join(DOT,
                    imgUploadConfig.getMiniThumbnailWidth(), imgUploadConfig.getMiniThumbnailHeight(), fileName));

            InputStream is = new FileInputStream(file);
            BufferedImage buff = ImageIO.read(is);
            int mediumWidth = buff.getWidth() / 2;   //得到图片的宽度
            int mediumHeight = buff.getHeight() / 2;  //得到图片的高度
            is.close(); //关闭Stream

            File mediumFile = new File(folder, CoreStringUtils.join(DOT, "medium", mediumWidth, mediumHeight, fileName));

            this.deleteFile(file);
            this.deleteFile(miniFile);
            this.deleteFile(mediumFile);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public boolean deleteFile(File file) {
        boolean flag = FileUtils.deleteQuietly(file);
        if (flag) {
            logger.info("删除文件[{}]成功", file.getAbsolutePath());
        } else {
            logger.error("删除文件[{}]失败", file.getAbsolutePath());
        }
        return flag;
    }

    /**
     * @param fileName 全路径图片地址
     * @return
     */
    @Override
    public File getMiniImgFile(String fileName) {
        File folder = new File(imgUploadConfig.getPath(), imgUploadConfig.getFolder());
        File miniFile = new File(folder, CoreStringUtils.join(DOT,
                imgUploadConfig.getMiniThumbnailWidth(), imgUploadConfig.getMiniThumbnailHeight(), fileName));
        return miniFile.exists() ? miniFile : null;
    }

    /**
     * @param fileName 全路径图片地址
     * @return
     */
    @Override
    public File getMediumImgFile(String fileName) {
        try {
            File folder = new File(imgUploadConfig.getPath(), imgUploadConfig.getFolder());
            File file = new File(folder, fileName);

            InputStream is = new FileInputStream(file);
            BufferedImage buff = ImageIO.read(is);
            int mediumWidth = buff.getWidth() / 2;   //得到图片的宽度
            int mediumHeight = buff.getHeight() / 2;  //得到图片的高度
            is.close(); //关闭Stream

            File mediumFile = new File(folder, CoreStringUtils.join(DOT, "medium", mediumWidth, mediumHeight, fileName));
            return mediumFile.exists() ? mediumFile : null;
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public String getHttpPath(String type) {
        if (type.equals("img")) {
            return imgUploadConfig.getDomainName()+imgUploadConfig.getFolder();
        }
        return null;
    }
}
