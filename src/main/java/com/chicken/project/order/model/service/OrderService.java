package com.chicken.project.order.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.order.model.dao.OrderMapper;
import com.chicken.project.order.model.dto.InterestDTO;
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

    public List<OrderDTO> selectAllItem(SelectCriteria selectCriteria) {

        return orderMapper.selectAllItem(selectCriteria);

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

//    public int selectInterestCount(InterestDTO interest) {
//
//        int interCheck = orderMapper.selectInterestCount(interest);
//
//        if(!(interCheck > 0)) {
//            throw new interestRegistException("")
//        }
//
//        return interCheck;
//    }
//
//    public int insertInterest(InterestDTO interest) {
//
//        int insert = orderMapper.insertIterest(interest);
//
//        if(insert > 0) {
//            replyList = mapper.selectReplyList(registReply.getRefBoardNo());
//        } else {
//            throw new ReplyRegistException("댓글 등록에 실패하셨습니다.");
//        }









//        return insert;


//    }

//    public int deleteInterest(InterestDTO interest) {
//
//        int
//
//    }
}