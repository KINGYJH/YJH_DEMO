package com.yjh.demo.application.messages.representation.mapping;

import com.yjh.demo.application.messages.representation.MessagesInfoRepresentation;
import com.yjh.demo.domain.mode.message.Messages;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/4/7 0007.
 */
@Component
public class MessagesInfoRepresentationMapper extends CustomMapper<Messages, MessagesInfoRepresentation> {
}
