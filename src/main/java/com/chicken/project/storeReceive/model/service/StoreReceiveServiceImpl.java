package com.chicken.project.storeReceive.model.service;

import com.chicken.project.storeReceive.model.dao.StoreReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreReceiveServiceImpl implements StoreReceiveService{

    private final StoreReceiveMapper storeReceiveMapper;

    @Autowired
    public StoreReceiveServiceImpl(StoreReceiveMapper storeReceiveMapper){

        this.storeReceiveMapper = storeReceiveMapper;
    }


}
