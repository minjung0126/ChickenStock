package com.chicken.project.order.model.service;

import com.chicken.project.order.model.dao.OrderMapper;
import com.chicken.project.order.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {

        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> selectAllItem() {

        return orderMapper.selectAllItem();

    }

    public List<OrderDTO> selectCartItem() {

        return orderMapper.selectCartItem();

    }

    public List<OrderDTO> selectOrderHistory() {

        return orderMapper.selectOrderHistory();
    }


    public int selectTotalCount(Map<String, String> searchMap) {

        int result = orderMapper.selectTotalCount(searchMap);

        return result;

    }
}