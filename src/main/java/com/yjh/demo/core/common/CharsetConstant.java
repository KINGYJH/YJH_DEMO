package com.yjh.demo.core.common;

import java.nio.charset.Charset;

/**
 * 字符集
 * <p>
 * Created by YJH on 2016/3/2.
 */
public class CharsetConstant {

    public static final String DEFAULT_STRING = "UTF-8";

    public static final String UTF8_STRING = "UTF-8";

    public static final String GBK_STRING = "GBK";

    public static final String GB2312_STRING = "gb2312";

    public static final String ISO_8859_1_STRING = "iso-8859-1";

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static final Charset GBK_CHARSET = Charset.forName("GBK");

    public static final Charset GB2312_CHARSET = Charset.forName("gb2312");

    public static final Charset ISO_8859_1_CHARSET = Charset.forName("iso-8859-1");

}
