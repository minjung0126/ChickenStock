package com.chicken.project.receive.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.receive.model.dao.ReceiveMapper;
import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import com.chicken.project.receive.model.dto.ReceiveOfficeItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("receiveService")
public class ReceiveService {

    private final ReceiveMapper receiveMapper;

    public ReceiveService(ReceiveMapper receiveMapper){

        this.receiveMapper = receiveMapper;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = receiveMapper.selectTotalCount(searchMap);

        return result;
    }

    public List<ReceiveOfficeDTO> selectAllReceive(SelectCriteria selectCriteria) {

        List<ReceiveOfficeDTO> receiveOfficeList = receiveMapper.selectAllReceive(selectCriteria);
        return receiveOfficeList;
    }

    public List<ReceiveOfficeItemDTO> selectAllReceiveItem(String recCode) {

        return receiveMapper.selectAllReceiveItem(recCode);
    }


    public int selectItemTotalCount(Map<String, String> searchMap) {

        return receiveMapper.selectItemTotalCount(searchMap);
    }

    public List<ReceiveOfficeDTO> selectAllItem(SelectCriteria selectCriteria) {

        return receiveMapper.selectAllItem(selectCriteria);
    }
}
