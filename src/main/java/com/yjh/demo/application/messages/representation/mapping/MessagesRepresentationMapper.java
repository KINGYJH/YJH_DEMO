package com.yjh.demo.application.messages.representation.mapping;

import com.yjh.demo.application.messages.representation.MessagesRepresentation;
import com.yjh.demo.domain.mode.message.Messages;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/4/7.
 */
@Component
public class MessagesRepresentationMapper extends CustomMapper<Messages, MessagesRepresentation> {
}
