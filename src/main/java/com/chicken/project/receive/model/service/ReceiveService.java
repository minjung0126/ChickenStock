package com.chicken.project.receive.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.receive.ReceiveInsertException;
import com.chicken.project.exception.receive.ReceiveUpdateException;
import com.chicken.project.item.model.dto.ItemInfoDTO;
import com.chicken.project.receive.model.dao.ReceiveMapper;
import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import com.chicken.project.receive.model.dto.ReceiveOfficeItemDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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

        int result = receiveMapper.selectItemTotalCount(searchMap);

        return result;
    }

    public List<ReceiveOfficeDTO> selectAllItem(SelectCriteria selectCriteria) {

        return receiveMapper.selectAllItem(selectCriteria);
    }

    public List<ItemInfoDTO> selectRegistReceive(List<String> itemNoList) {

        return receiveMapper.selectRegistReceive(itemNoList);
    }

    @Transactional
    public void insertReceiveOffice(String empName) throws ReceiveInsertException{
        
        int result = receiveMapper.insertReceiveOffice(empName);

        if(!(result > 0)) {
            throw new ReceiveInsertException("입고 등록에 실패하셨습니다.");
        }
    }

    @Transactional
    public void insertReceiveOfficeItem(HashMap<String, Object> registHashMap) throws ReceiveInsertException{

        int result = receiveMapper.insertReceiveOfficeItem(registHashMap);

        if(!(result > 0)) {
            throw new ReceiveInsertException("입고 등록에 실패하셨습니다.");
        }
    }
    @Transactional
    public void insertItemHistory(HashMap<String, Object> registHashMap) throws ReceiveInsertException{

        int result = receiveMapper.insertItemHistory(registHashMap);

        if(!(result > 0)) {
            throw new ReceiveInsertException("입고 등록에 실패하셨습니다.");
        }
    }

    public List<ReceiveOfficeDTO> selectMaxCode() {

        return receiveMapper.selectMaxCode();
    }

    @Transactional
    public void updateItem(HashMap<String, Object> registHashMap) throws ReceiveUpdateException {

        int result = receiveMapper.updateItem(registHashMap);

        if(!(result > 0)) {
            throw new ReceiveUpdateException("재고 수정에 실패하셨습니다.");
        }
    }
}
