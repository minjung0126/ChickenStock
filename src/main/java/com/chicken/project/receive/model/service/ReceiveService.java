package com.chicken.project.receive.model.service;

import com.chicken.project.receive.model.dao.ReceiveMapper;
import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import com.chicken.project.receive.model.dto.ReceiveOfficeItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("receiveService")
public class ReceiveService {

    private final ReceiveMapper receiveMapper;

    public ReceiveService(ReceiveMapper receiveMapper){

        this.receiveMapper = receiveMapper;
    }

    public List<ReceiveOfficeDTO> selectAllReceive() {

        return receiveMapper.selectAllReceive();
    }

    public List<ReceiveOfficeItemDTO> selectAllReceiveItem() {

        return receiveMapper.selectAllReceiveItem();
    }
}
