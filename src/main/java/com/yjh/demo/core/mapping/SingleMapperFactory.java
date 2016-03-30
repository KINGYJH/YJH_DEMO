package com.yjh.demo.core.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by YJH on 2016/3/7.
 */
public class SingleMapperFactory {

    private FinalWrapper wrapper;

    public MapperFactory instance() {
        FinalWrapper w = wrapper;
        if (w == null) { // check 1
            synchronized (this) {
                w = wrapper;
                if (w == null) { // check2
                    w = new FinalWrapper(new DefaultMapperFactory.Builder().build());
                    wrapper = w;
                }
            }
        }
        return w.instance;
    }

    private static class FinalWrapper {
        public final MapperFactory instance;

        public FinalWrapper(MapperFactory instance) {
            this.instance = instance;
        }
    }

}
