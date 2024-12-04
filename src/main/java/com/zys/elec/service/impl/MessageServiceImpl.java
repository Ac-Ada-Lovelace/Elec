package com.zys.elec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zys.elec.entity.Message;
import com.zys.elec.mapper.MessageMapper;
import com.zys.elec.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public int createMessage(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int deleteMessage(Long id) {
        return messageMapper.deleteById(id);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.update(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageMapper.selectById(id);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageMapper.selectAll();
    }
}