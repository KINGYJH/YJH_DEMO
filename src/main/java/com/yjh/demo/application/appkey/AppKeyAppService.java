package com.yjh.demo.application.appkey;

import com.yjh.demo.domain.service.appkey.IAppKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("appKeyAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AppKeyAppService implements IAppKeyAppService {

    @Autowired
    private IAppKeyService appKeyService;

}
