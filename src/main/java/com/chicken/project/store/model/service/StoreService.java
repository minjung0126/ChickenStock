package com.chicken.project.store.model.service;

import com.chicken.project.exception.store.StoreDeleteException;
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

    public void deleteStore(String storeName) throws StoreDeleteException {

        int result = storeMapper.deleteStore(storeName);

        if(!(result > 0)){
            throw new StoreDeleteException("가맹점 정보 삭제에 실패하셨습니다.");
        }
    }
}
