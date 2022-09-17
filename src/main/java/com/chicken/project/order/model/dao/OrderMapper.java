package com.chicken.project.order.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.dto.OrderHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    List<OrderDTO> selectAllItem(SelectCriteria selectCriteria);

    List<CartDTO> selectCartItem(SelectCriteria selectCriteria);

    List<OrderDTO> selectOrderHistory();

    int selectTotalCount(Map<String, String> searchMap);

    int selectInterestCount(InterestDTO interest);

    int insertInterest(InterestDTO interest);

    int deleteInterest(InterestDTO interest);

    int selectAvailableItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectAvailableItem(SelectCriteria selectCriteria);

    int selectInterestItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectInterestItem(SelectCriteria selectCriteria);

    int insertCartList(List<String> itemNoList);

    int insertItemIntoCart(int itemNo, int cartAmount, String storeName);

    String deleteCartItem(int cartNo);

    int insertStoreOrderNo(CartDTO cart);

    int insertOrderItems(CartDTO cart);

    void insertOrderHandler(CartDTO cart);

    void resetCartItems(CartDTO cart);
}