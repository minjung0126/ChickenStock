package com.chicken.project.order.model.dao;

import com.chicken.project.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper {
    List<OrderDTO> findAllItem();
}
