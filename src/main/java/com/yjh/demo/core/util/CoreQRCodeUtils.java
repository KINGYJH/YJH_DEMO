package com.yjh.demo.core.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by YJH on 2016/4/28.
 */
public class CoreQRCodeUtils {

    private static int IMAGE_WIDTH = 90;

    private static int IMAGE_HEIGHT = 90;


    public static void setImageWidth(int imageWidth) {
        IMAGE_WIDTH = imageWidth;
        IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;
    }

    public static void setImageHeight(int imageHeight) {
        IMAGE_HEIGHT = imageHeight;
    }

    private static int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;

    private static final int FRAME_WIDTH = 2;

    private static final String SUFFIX = "jpg";

    private static MultiFormatWriter WRITER = new MultiFormatWriter();


    /**
     * @param content      二维码显示的文本
     * @param width        二维码的宽度
     * @param height       二维码的高度
     * @param srcImagePath 中间嵌套的图片
     * @param desImagePath 二维码生成的地址
     */
    public static void encode(String content, int width, int height,
                              String srcImagePath, String desImagePath) {
        try {
            ImageIO.write(genBarcode(content, width, height, srcImagePath, "utf-8"),
                    SUFFIX, new File(desImagePath));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param content      二维码显示的文本
     * @param width        二维码的宽度
     * @param height       二维码的高度
     * @param srcImagePath 中间嵌套的图片
     * @param desImagePath 二维码生成的地址
     * @param suffix       图片后缀
     */
    public static void encode(String content, int width, int height,
                              String srcImagePath, String desImagePath, String suffix) {
        try {
            ImageIO.write(genBarcode(content, width, height, srcImagePath, "UTF-8"),
                    suffix, new File(desImagePath));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param content      二维码显示的文本
     * @param width        二维码的宽度
     * @param height       二维码的高度
     * @param srcImagePath 中间嵌套的图片
     * @param desImagePath 二维码生成的地址
     * @param suffix       图片后缀
     * @param charset      编码
     */
    public static void encode(String content, int width, int height,
                              String srcImagePath, String desImagePath, String suffix, String charset) {
        try {
            ImageIO.write(genBarcode(content, width, height, srcImagePath, charset),
                    suffix, new File(desImagePath));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到BufferedImage
     *
     * @param content      二维码显示的文本
     * @param width        二维码的宽度
     * @param height       二维码的高度
     * @param srcImagePath 中间嵌套的图片
     * @param charset      编码
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static BufferedImage genBarcode(String content, int width,
                                           int height, String srcImagePath, String charset) throws WriterException,
            IOException {
        // 读取源图像
        BufferedImage scaleImage = scale(srcImagePath, IMAGE_WIDTH,
                IMAGE_HEIGHT, true);

        int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT];
        for (int i = 0; i < scaleImage.getWidth(); i++) {
            for (int j = 0; j < scaleImage.getHeight(); j++) {
                srcPixels[i][j] = scaleImage.getRGB(i, j);
            }
        }

        Hashtable hint = new Hashtable();
        hint.put(EncodeHintType.CHARACTER_SET, charset);
        hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 生成二维码
        BitMatrix matrix = WRITER.encode(content, BarcodeFormat.QR_CODE,
                width, height, hint);

        // 二维矩阵转为一维像素数组
        int halfW = matrix.getWidth() / 2;
        int halfH = matrix.getHeight() / 2;
        int[] pixels = new int[width * height];

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                // 读取图片
                if (x > halfW - IMAGE_HALF_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH
                        && y < halfH + IMAGE_HALF_WIDTH) {
                    pixels[y * width + x] = srcPixels[x - halfW
                            + IMAGE_HALF_WIDTH][y - halfH + IMAGE_HALF_WIDTH];
                }
                // 在图片四周形成边框
                else if ((x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW - IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        + IMAGE_HALF_WIDTH + FRAME_WIDTH)
                        || (x > halfW + IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        + IMAGE_HALF_WIDTH + FRAME_WIDTH)
                        || (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        - IMAGE_HALF_WIDTH + FRAME_WIDTH)
                        || (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH + IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        + IMAGE_HALF_WIDTH + FRAME_WIDTH)) {
                    pixels[y * width + x] = 0xfffffff;
                } else {
                    // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                    pixels[y * width + x] = matrix.get(x, y) ? 0xff000000
                            : 0xfffffff;
                }
            }
        }

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        image.getRaster().setDataElements(0, 0, width, height, pixels);

        return image;
    }

    /**
     * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标
     *
     * @param srcImageFile 源文件地址
     * @param height       目标高度
     * @param width        目标宽度
     * @param hasFiller    比例不对时是否需要补白：true为补白; false为不补白;
     * @throws IOException
     */
    private static BufferedImage scale(String srcImageFile, int height,
                                       int width, boolean hasFiller) throws IOException {
        double ratio; // 缩放比例
        File file = new File(srcImageFile);
        BufferedImage srcImage = ImageIO.read(file);
        Image desImage = srcImage.getScaledInstance(width, height,
                BufferedImage.SCALE_SMOOTH);
        // 计算比例
        if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
            if (srcImage.getHeight() > srcImage.getWidth()) {
                ratio = (new Integer(height)).doubleValue()
                        / srcImage.getHeight();
            } else {
                ratio = (new Integer(width)).doubleValue()
                        / srcImage.getWidth();
            }
            AffineTransformOp op = new AffineTransformOp(AffineTransform
                    .getScaleInstance(ratio, ratio), null);
            desImage = op.filter(srcImage, null);
        }
        if (hasFiller) {// 补白
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphic = image.createGraphics();
            graphic.setColor(Color.white);
            graphic.fillRect(0, 0, width, height);
            if (width == desImage.getWidth(null))
                graphic.drawImage(desImage, 0, (height - desImage
                                .getHeight(null)) / 2, desImage.getWidth(null),
                        desImage.getHeight(null), Color.white, null);
            else
                graphic.drawImage(desImage,
                        (width - desImage.getWidth(null)) / 2, 0, desImage
                                .getWidth(null), desImage.getHeight(null),
                        Color.white, null);
            graphic.dispose();
            desImage = image;
        }
        return (BufferedImage) desImage;
    }

    public static void main(String[] args) {
        CoreQRCodeUtils
                .encode("http://www.baidu.com",
                        500, 500, "/home/yjh/桌面/logo.jpg", "/home/yjh/桌面/test.jpg");
    }

}