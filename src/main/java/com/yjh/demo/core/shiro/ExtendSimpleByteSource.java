package com.yjh.demo.core.shiro;


import org.apache.shiro.util.SimpleByteSource;

import java.io.Serializable;

/**
 * 扩展SimpleByteSource实现序列化
 * Created by YJH on 2016/4/5 0005.
 */
public class ExtendSimpleByteSource extends SimpleByteSource implements Serializable {

    public ExtendSimpleByteSource(String string) {
        super(string);
    }
}
