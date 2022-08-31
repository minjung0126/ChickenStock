package com.chicken.project.store.model.service;

import com.chicken.project.store.model.dao.StoreMapper;
import com.chicken.project.store.model.dto.StoreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeService")
public class StoreService {

    private final StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper){

        this.storeMapper = storeMapper;
    }
    public List<StoreDTO> storeList() {

        return storeMapper.storeList();
    }
}
