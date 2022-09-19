package com.chicken.project.order.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.dto.OrderHistoryDTO;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderDTO> selectAllItem(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);

    int selectInterestCount(InterestDTO interest);

    int insertInterest(InterestDTO interest) throws InterestException;

    int deleteInterest(InterestDTO interest) throws InterestException;

    int selectCartTotalCount(Map<String, String> searchMap);

    List<CartDTO> selectCartItem(SelectCriteria selectCriteria);

    int selectAvailableItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectAvailableItem(SelectCriteria selectCriteria);

    int selectInterestItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectInterestItem(SelectCriteria selectCriteria);


//    void InsertCartList(List<String> itemNoList);

    /* 발주 신청 완료 */

    void insertItemIntoCart(int itemNo, int cartAmount, String storeName);


    int insertStoreOrderNo(CartDTO cart);

    int insertOrderItems(CartDTO cart);

    int insertOrderHandler(CartDTO cart);

    void resetCartItems(CartDTO cart);

    void deleteCartItem(CartDTO cart);

    int selectOrderHistoryCount(Map<String, String> searchMap);

    List<OrderHistoryDTO> selectOrderHistory(SelectCriteria selectCriteria);

}
