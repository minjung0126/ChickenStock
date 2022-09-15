package com.chicken.project.storeItem.model.service;

import com.chicken.project.storeItem.model.dto.StoreItemListDTO;

import java.util.List;

public interface StoreItemService {
    List<StoreItemListDTO> itemListSelect();
}
