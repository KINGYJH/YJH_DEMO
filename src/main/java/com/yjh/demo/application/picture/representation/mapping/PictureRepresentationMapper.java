package com.yjh.demo.application.picture.representation.mapping;

import com.yjh.demo.application.picture.representation.PictureRepresentation;
import com.yjh.demo.domain.mode.picture.Picture;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/4/12 0012.
 */
@Component
public class PictureRepresentationMapper extends CustomMapper<Picture, PictureRepresentation> {
}
