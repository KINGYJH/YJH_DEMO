package com.yjh.demo.application.role;

import com.yjh.demo.domain.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("roleAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class RoleAppService implements IRoleAppService {

    @Autowired
    private IRoleService roleService;

}
