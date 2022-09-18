package com.chicken.project.storeReceive.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeReceive.model.dto.RecStoreOrderDTO;
import com.chicken.project.storeReceive.model.dto.ReceiveStoreDTO;

import java.util.List;
import java.util.Map;

public interface StoreReceiveService {

    List<RecStoreOrderDTO> selectAllOrder();

    List<RecStoreOrderDTO> selectAllReceive();

    List<RecStoreOrderDTO> selectAllOrderItem(int orderNo);

    List<RecStoreOrderDTO> selectAllReceiveItem(int orderNo);
}
