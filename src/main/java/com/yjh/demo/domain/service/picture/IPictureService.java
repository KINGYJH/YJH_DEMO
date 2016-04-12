package com.yjh.demo.domain.service.picture;

import com.yjh.demo.application.picture.command.CreatePictureCommand;
import com.yjh.demo.domain.mode.picture.Picture;

/**
 * Created by YJH on 2016/4/12.
 */
public interface IPictureService {
    Picture create(CreatePictureCommand command);

    Picture searchBuID(String id);

    void delete(String id);
}
