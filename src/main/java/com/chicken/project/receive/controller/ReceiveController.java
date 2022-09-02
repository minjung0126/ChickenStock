package com.chicken.project.receive.controller;

import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import com.chicken.project.receive.model.dto.ReceiveOfficeItemDTO;
import com.chicken.project.receive.model.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/receive")
public class ReceiveController {

    private final ReceiveService receiveService;

    @Autowired
    public ReceiveController(ReceiveService receiveService){

        this.receiveService = receiveService;
    }

    @GetMapping("/admin/list")
    public ModelAndView receiveList(ModelAndView mv){

        List<ReceiveOfficeDTO> receiveOfficeList = receiveService.selectAllReceive();
        List<ReceiveOfficeItemDTO> receiveOfficeItemList = receiveService.selectAllReceiveItem();
        for(ReceiveOfficeItemDTO receiveOffice : receiveOfficeItemList){
            System.out.println("receiveOffice = " + receiveOffice);
        }
        mv.addObject("receiveOfficeList", receiveOfficeList);
        mv.addObject("receiveOfficeItemList", receiveOfficeItemList);
        mv.setViewName("receive/admin/admin_receive");

        return mv;
    }
}
