package com.chicken.project.order.model.service;

import com.chicken.project.order.model.dao.OrderMapper;
import com.chicken.project.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    public OrderService(OrderMapper orderMapper){

        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> findAllItem() {

        return orderMapper.findAllItem();

    }
}
