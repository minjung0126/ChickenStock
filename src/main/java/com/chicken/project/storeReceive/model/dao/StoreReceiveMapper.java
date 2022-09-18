package com.chicken.project.storeReceive.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeReceive.model.dto.RecStoreOrderDTO;
import com.chicken.project.storeReceive.model.dto.ReceiveStoreDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreReceiveMapper {

    List<RecStoreOrderDTO> selectAllOrder();

    List<RecStoreOrderDTO> selectAllReceive();

    List<RecStoreOrderDTO> selectAllOrderItem(int orderNo);

    List<RecStoreOrderDTO> selectAllReceiveItem(int orderNo);
}
