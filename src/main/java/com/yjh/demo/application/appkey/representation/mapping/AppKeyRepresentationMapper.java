package com.yjh.demo.application.appkey.representation.mapping;

import com.yjh.demo.application.appkey.representation.AppKeyRepresentation;
import com.yjh.demo.domain.mode.appkey.AppKey;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/3/30 0030.
 */
@Component
public class AppKeyRepresentationMapper extends CustomMapper<AppKey,AppKeyRepresentation> {
}
