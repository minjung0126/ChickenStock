package com.chicken.project.order.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    List<OrderDTO> selectAllItem(SelectCriteria selectCriteria);

    List<OrderDTO> selectCartItem();

    List<OrderDTO> selectOrderHistory();

    int selectTotalCount(Map<String, String> searchMap);

    int selectInterestCount(InterestDTO interest);
}
