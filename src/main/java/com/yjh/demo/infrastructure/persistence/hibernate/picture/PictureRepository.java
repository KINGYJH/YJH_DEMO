package com.yjh.demo.infrastructure.persistence.hibernate.picture;

import com.yjh.demo.domain.mode.picture.IPictureRepository;
import com.yjh.demo.domain.mode.picture.Picture;
import com.yjh.demo.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/4/12.
 */
@Repository("pictureRepository")
public class PictureRepository extends AbstractHibernateGenericRepository<Picture, String>
        implements IPictureRepository<Picture, String> {
}
