package com.yjh.demo.domain.service.picture;

import com.yjh.demo.application.picture.command.CreatePictureCommand;
import com.yjh.demo.core.exception.NoFoundException;
import com.yjh.demo.domain.mode.picture.IPictureRepository;
import com.yjh.demo.domain.mode.picture.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YJH on 2016/4/12.
 */
@Service("pictureService")
public class PictureService implements IPictureService {

    @Autowired
    private IPictureRepository<Picture, String> pictureRepository;

    @Override
    public Picture create(CreatePictureCommand command) {
        Picture picture = new Picture(command.getPicPath(), command.getMiniPicPath(),
                command.getMediumPicPath(), command.getSize(), command.getName());
        pictureRepository.save(picture);
        return picture;
    }

    @Override
    public Picture searchBuID(String id) {
        Picture picture = pictureRepository.getById(id);
        if (null == picture) {
            throw new NoFoundException("没有找到ID[" + id + "]的Picture数据");
        }
        return picture;
    }

    @Override
    public void delete(String id) {
        Picture picture = this.searchBuID(id);
        pictureRepository.delete(picture);
    }

}
