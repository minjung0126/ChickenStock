package com.chicken.project.storeReceive.model.service;

import com.chicken.project.storeReceive.model.dao.StoreReceiveMapper;
import com.chicken.project.storeReceive.model.dto.RecStoreOrderDTO;
import com.chicken.project.storeReceive.model.dto.ReceiveStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreReceiveServiceImpl implements StoreReceiveService{

    private final StoreReceiveMapper storeReceiveMapper;

    @Autowired
    public StoreReceiveServiceImpl(StoreReceiveMapper storeReceiveMapper){

        this.storeReceiveMapper = storeReceiveMapper;
    }

    @Override
    public List<RecStoreOrderDTO> selectAllOrder() {

        List<RecStoreOrderDTO> orderList = storeReceiveMapper.selectAllOrder();

        return orderList;
    }

    @Override
    public List<ReceiveStoreDTO> selectAllReceive() {

        List<ReceiveStoreDTO> receiveList = storeReceiveMapper.selectAllReceive();

        return receiveList;
    }

    @Override
    public List<RecStoreOrderDTO> selectAllOrderItem(int orderNo) {

        List<RecStoreOrderDTO> orderItemList = storeReceiveMapper.selectAllOrderItem(orderNo);

        return orderItemList;
    }
}
