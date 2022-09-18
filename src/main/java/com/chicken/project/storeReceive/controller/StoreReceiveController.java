package com.chicken.project.storeReceive.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dto.StoreImpl;
import com.chicken.project.storeReceive.model.dto.RecStoreOrderDTO;
import com.chicken.project.storeReceive.model.dto.ReceiveStoreDTO;
import com.chicken.project.storeReceive.model.service.StoreReceiveServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/storeReceive")
public class StoreReceiveController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final StoreReceiveServiceImpl storeReceiveService;

    @Autowired
    public StoreReceiveController(StoreReceiveServiceImpl storeReceiveService){

        this.storeReceiveService = storeReceiveService;
    }

    @GetMapping("/user/list")
    public ModelAndView storeReceiveList(HttpServletRequest request, ModelAndView mv, @RequestParam(value="startDate", required = false) String startDate, @RequestParam(value="endDate", required = false) String endDate, @AuthenticationPrincipal StoreImpl store){



        List<RecStoreOrderDTO> orderList = storeReceiveService.selectAllOrder();
        List<ReceiveStoreDTO> receiveList = storeReceiveService.selectAllReceive();

        List<List<RecStoreOrderDTO>> orderItem = new ArrayList<>();
        for(int i = 0; i < orderList.size(); i++){

            if(orderList.get(i).getReceiveStore().getRecCode() == null){
                List<RecStoreOrderDTO> orderItemList = storeReceiveService.selectAllOrderItem(orderList.get(i).getOrderNo());
                orderItem.add(orderItemList);
            }
        }



        mv.addObject("orderList", orderList);
        mv.addObject("receiveList", receiveList);
        mv.addObject("orderItem", orderItem);


        mv.setViewName("receive/user/user_receive");

        return mv;
    }
}
