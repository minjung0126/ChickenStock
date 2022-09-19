package com.chicken.project.storeReceive.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeReceive.model.dao.StoreReceiveMapper;
import com.chicken.project.storeReceive.model.dto.RecReleaseDTO;
import com.chicken.project.storeReceive.model.dto.RecReleaseItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreReceiveServiceImpl implements StoreReceiveService{

    private final StoreReceiveMapper storeReceiveMapper;

    @Autowired
    public StoreReceiveServiceImpl(StoreReceiveMapper storeReceiveMapper){

        this.storeReceiveMapper = storeReceiveMapper;
    }


    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = storeReceiveMapper.selectTotalCount(searchMap);

        return result;
    }

    @Override
    public List<RecReleaseDTO> selectAllRelease(SelectCriteria selectCriteria) {

        List<RecReleaseDTO> releaseList = storeReceiveMapper.selectAllRelease(selectCriteria);
        return releaseList;
    }

    @Override
    public List<RecReleaseItemDTO> selectAllItem(String relCode) {

        List<RecReleaseItemDTO> itemList = storeReceiveMapper.selectAllItem(relCode);

        return itemList;
    }
}
