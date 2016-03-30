package com.yjh.demo.core.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Date;
import java.util.zip.CRC32;

/**
 * Created by YJH on 2016/3/1.
 */
public class CoreStringUtils {
    private static final Logger log = LoggerFactory.getLogger(CoreStringUtils.class);

    public static final String EMPTY = CoreStringUtils.EMPTY;

    public static boolean isEmpty(String seq) {
        return StringUtils.isEmpty(seq);
    }

    public static boolean contains(String seq, String searchSeq) {
        return CoreStringUtils.contains(seq, searchSeq);
    }

    public static String[] split(String seq, String separatorChar) {
        return CoreStringUtils.split(seq, separatorChar);
    }

    /**
     * 字符串拼接
     * @param delimiter 拼接分割符
     * @param objects   拼接字符串数组
     * @return
     */
    public static String join(String delimiter, Object...objects) {
        StringBuilder buffer = new StringBuilder(256);
        boolean hasDelimiter = !isEmpty(delimiter);
        for (int i = 0, length = objects.length; i < length; i++) {
            buffer.append(objects[i]);
            if (hasDelimiter && i + 1 != length) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }

    /**
     * url编码
     * @param src     编码内容
     * @param charset 字符集
     * @return
     */
    public static String urlEncode(String src, String charset) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(src, charset);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        return  encoded;
    }

    /**
     * url解码
     * @param src     编码内容
     * @param charset 字符集
     * @return
     */
    public static String urlDecode(String src, String charset) {
        String encoded = null;
        if (null != src) {
            try {
                encoded = URLDecoder.decode(src, charset);
            } catch (UnsupportedEncodingException e) {
                log.error(e.getMessage(), e);
            }
        }
        return  encoded;
    }

    public static String unicodeToString(String str) {
        StringBuilder src = new StringBuilder(str);
        StringBuilder des = new StringBuilder();

        char[] unicodeBuffer = new char[6];
        int unicodeBufferIndex = -1;

        int srcLength = src.length();
        int readIndex = -1;
        while ((++readIndex) < srcLength) {
            char c = src.charAt(readIndex);
            // 已有前序的匹配
            switch (unicodeBufferIndex) {
                case -1:
                    if (c != '\\') {
                        break;
                    } else {
                        unicodeBufferIndex ++;
                        unicodeBuffer[unicodeBufferIndex] = c;
                        continue;
                    }
                case 0:
                    if (c != 'u') {
                        break;
                    } else {
                        unicodeBufferIndex ++;
                        unicodeBuffer[unicodeBufferIndex] = c;
                        continue;
                    }
                case 1:
                case 2:
                case 3:
                case 4:
                    // 判断16进制字符
                    if ((c >= 48 && c <= 57) || (c >= 97 && c <= 102)) {
                        unicodeBufferIndex ++;
                        unicodeBuffer[unicodeBufferIndex] = c;

                        if (unicodeBufferIndex == 5) {
                            // 完全匹配，执行转换
                            StringBuffer chBuffer = new StringBuffer();
                            for (int i = 2; i <= unicodeBufferIndex; i++) {
                                chBuffer.append(unicodeBuffer[i]);
                            }
                            char ch = (char)Integer.parseInt(chBuffer.toString(), 16);
                            des.append(ch);

                            unicodeBufferIndex = -1;
                            continue;
                        }

                        continue;
                    } else {
                        break;
                    }
            }

            // 匹配的都已经continue了，这里处理匹配失败的
            for (int i = 0; i <= unicodeBufferIndex; i ++) {
                des.append(unicodeBuffer[i]);
            }
            des.append(c);
            unicodeBufferIndex = -1;
        }
        return des.toString();
    }

    public static String trim(String src) {
        return StringUtils.trim(src);
    }

    /**
     * Hash crc32校验
     * @param src
     * @return
     */
    public static String hashCRC32(String src) {
        CRC32 crc32 = new CRC32();
        crc32.update(src.getBytes());
        return Long.toHexString(crc32.getValue());
    }

    public final static String md5(String src, int length, boolean upCase, String charset) {

        if (org.apache.commons.lang3.StringUtils.isEmpty(src)) {
            throw new NullPointerException("The src must not be null.");
        }

        if (!(length == 16 || length == 32)) {
            throw new IllegalArgumentException("The length value only is 16 or 32.");
        }

        String result = null;
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            byte[] md = mdInst.digest(src.getBytes(charset));
            StringBuilder sb = new StringBuilder();
            for (byte b : md) {
                int val = b & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }

            result = length == 16 ? sb.substring(8, 23) : sb.toString();

            return upCase ? result.toUpperCase() : result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    /**
     * 对src进行左补src.length() - length 个零操作
     * 如果src.length <＝ length 直接返回
     * @param src
     * @param length
     * @return
     */
    public final static String fillZero(long src, int length) {
        String tmp = String.valueOf(src);
        int len = tmp.length();
        if (len >= length) {
            return String.valueOf(src);
        }

        return String.format("%0" +  length + "d", src);
    }

    /**
     * 对src进行左补src.length() - length 个长度的随机数操作
     * 如果src.length <＝ length 直接返回
     * @param src
     * @param length
     * @return
     */
    public final static String fillRandomVal(long src, int length) {
        String tmp = String.valueOf(src);
        int len = tmp.length();
        if (len >= length) {
            return String.valueOf(src);
        }

        int diffLen = length - len;
        long time = new Date().getTime() / diffLen;

        String timeStr = String.valueOf(time);
        int timeStrLen = timeStr.length();

        return src + String.valueOf(time).substring(timeStrLen - diffLen, timeStrLen);
    }
}
