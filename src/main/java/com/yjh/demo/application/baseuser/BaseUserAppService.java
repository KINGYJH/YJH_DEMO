package com.yjh.demo.application.baseuser;

import com.yjh.demo.domain.service.baseuser.IBaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("baseUserAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BaseUserAppService implements IBaseUserAppService {

    @Autowired
    private IBaseUserService baseUserService;

}
