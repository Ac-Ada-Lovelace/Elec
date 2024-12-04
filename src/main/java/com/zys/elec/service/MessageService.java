package com.zys.elec.service;

import java.util.List;

import com.zys.elec.entity.Message;

public interface MessageService {
    int createMessage(Message message);
    int deleteMessage(Long id);
    int updateMessage(Message message);
    Message getMessageById(Long id);
    List<Message> getAllMessages();
}