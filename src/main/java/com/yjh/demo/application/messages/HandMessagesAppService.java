package com.yjh.demo.application.messages;

import com.yjh.demo.application.messages.command.CreateMessagesCommand;
import com.yjh.demo.application.messages.command.UpdateHandMessageStatusCommand;
import com.yjh.demo.application.messages.representation.HandMessagesRepresentation;
import com.yjh.demo.core.mapping.IMappingService;
import com.yjh.demo.domain.service.messages.IHandMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YJH on 2016/4/7.
 */
@Service("handMessagesAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class HandMessagesAppService implements IHandMessagesAppService {

    @Autowired
    private IHandMessagesService handMessagesService;

    @Autowired
    private IMappingService mappingService;


    @Override
    public void create(CreateMessagesCommand command) {
        handMessagesService.create(command);
    }

    @Override
    public void updateStatus(UpdateHandMessageStatusCommand command) {
        handMessagesService.updateStatus(command);
    }

    @Override
    public HandMessagesRepresentation searchByID(String id) {
        return mappingService.map(handMessagesService.searchByID(id), HandMessagesRepresentation.class, false);
    }
}
