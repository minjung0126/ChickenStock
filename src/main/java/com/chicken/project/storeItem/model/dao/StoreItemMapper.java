package com.chicken.project.storeItem.model.dao;

import com.chicken.project.storeItem.model.dto.StoreItemListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreItemMapper {
    List<StoreItemListDTO> itemListSelect();
}
