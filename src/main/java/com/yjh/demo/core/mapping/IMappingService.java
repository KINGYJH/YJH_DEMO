package com.yjh.demo.core.mapping;

import java.util.List;

/**
 * Created by YJH on 2016/3/7.
 */
public interface IMappingService {

    <A,B> List<B> mapAsList(List<A> sourceObject, Class<B> destinationClass);

    <A,B> B map(A sourceObject, Class<B> destinationClass, boolean cycles);

}
