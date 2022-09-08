package com.chicken.project.store.model.service;

import com.chicken.project.exception.store.StoreDeleteException;
import com.chicken.project.exception.store.StoreInsertException;
import com.chicken.project.exception.store.StoreUpdateException;
import com.chicken.project.store.model.dao.StoreMapper;
import com.chicken.project.store.model.dto.StoreDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("storeService")
public class StoreService {

    private final StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper){

        this.storeMapper = storeMapper;
    }
    /* 가맹점 조회 */
    public List<StoreDTO> storeList() {

        return storeMapper.storeList();
    }

    /* 가맹점 삭제 */
    @Transactional
    public void deleteStore(String storeName) throws StoreDeleteException {

        int result = storeMapper.deleteBalanceStore(storeName);

        if(!(result > 0)){

            throw new StoreDeleteException("가맹점 정보 삭제에 실패하셨습니다.");
        } else {

            int result2 = storeMapper.deleteStoreRole(storeName);

            if(result2 > 0){

                storeMapper.deleteStore(storeName);
            }
        }
    }

    /* 가맹점 등록 */
    @Transactional
    public void insertStore(StoreDTO store) throws StoreInsertException {

        int result = storeMapper.insertStore(store);

        if(!(result > 0)){
            throw new StoreInsertException("가맹점 등록 실패!");
        } else {

            int result2 = storeMapper.insertBalance(store.getStoreName(), store.getStoreId());

            if(result2 > 0){

                storeMapper.insertStoreRole(store);
            }
        }
    }

    /* 가맹점 명을 받아 가맹점 조회 */
    public StoreDTO selectStoreByName(String storeName) {

        return storeMapper.selectStoreByName(storeName);
    }

    /* 가맹점 정보 수정 */
    @Transactional
    public int updateStore(StoreDTO store) throws StoreUpdateException {

        int result = storeMapper.updateStore(store);

        if(!(result > 0)) {

            throw new StoreUpdateException("가맹점 정보 수정 실패!");
        }

        return result;
    }
}
