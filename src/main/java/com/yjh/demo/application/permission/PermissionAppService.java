package com.yjh.demo.application.permission;

import com.yjh.demo.domain.service.permission.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("permissionAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class PermissionAppService implements IPermissionAppService {

    @Autowired
    private IPermissionService permissionService;

}
