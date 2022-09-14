package com.chicken.project.order.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.order.model.dao.OrderMapper;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {

        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> selectAllItem(SelectCriteria selectCriteria) {

        return orderMapper.selectAllItem(selectCriteria);

    }


    public List<OrderDTO> selectOrderHistory() {

        return orderMapper.selectOrderHistory();
    }


    public int selectTotalCount(Map<String, String> searchMap) {

        int result = orderMapper.selectTotalCount(searchMap);

        return result;

    }

    public int selectInterestCount(InterestDTO interest) {

        int interCheck = orderMapper.selectInterestCount(interest);

        return interCheck;
    }

    @Transactional
    public int insertInterest(InterestDTO interest) throws InterestException {

        int insert = orderMapper.insertInterest(interest);

        if (!(insert > 0)) {

            throw new InterestException("관심 등록에 실패하셨습니다.");
        }

        return insert;
    }

    @Transactional
    public int deleteInterest(InterestDTO interest) throws InterestException {

        int delete = orderMapper.deleteInterest(interest);

        if (!(delete > 0)) {

            throw new InterestException("관심 삭제에 실패하셨습니다.");
        }

        return delete;

    }

    public int selectCartTotalCount(Map<String, String> searchMap) {

        int result = orderMapper.selectTotalCount(searchMap);

        return result;

    }


    public List<CartDTO> selectCartItem(SelectCriteria selectCriteria) {

        return orderMapper.selectCartItem(selectCriteria);
    }

    public int selectAvailableItemCount(Map<String, String> searchMap) {

        int result = orderMapper.selectAvailableItemCount(searchMap);

        return result;
    }

    public List<OrderDTO> selectAvailableItem(SelectCriteria selectCriteria) {

        return orderMapper.selectAvailableItem(selectCriteria);
    }

    public int selectInterestItemCount(Map<String, String> searchMap) {

        int result = orderMapper.selectInterestItemCount(searchMap);

        return result;
    }


    public List<OrderDTO> selectInterestItem(SelectCriteria selectCriteria) {

        return orderMapper.selectInterestItem(selectCriteria);

    }

    @Transactional
    public void InsertCartList(List<String> itemNoList) throws InterestException {

        int result = orderMapper.insertCartList(itemNoList);

        if(!(result > 0)) {
            throw new InterestException("장바구니 담기에 실패하셨습니다.");
        }

    }

    @Transactional
    public void insertItemIntoCart(int itemNo, int cartAmount) throws InterestException {

        int result = orderMapper.insertItemIntoCart(itemNo, cartAmount);

        if(!(result > 0)) {
            throw new InterestException("장바구니 담기에 실패하셨습니다.");
        }

    }
}