package com.chicken.project.store.model.dao;

import com.chicken.project.store.model.dto.StoreDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    List<StoreDTO> storeList();
    int deleteStore(String storeName);

    int insertStore(StoreDTO store);
}
