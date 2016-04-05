package com.yjh.demo.application.auth;

import com.yjh.demo.application.user.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YJH on 2016/4/5.
 */
@Service("authAppService")
public class AuthAppService implements IAuthAppService {

    @Autowired
    private IUserAppService userAppService;



}
