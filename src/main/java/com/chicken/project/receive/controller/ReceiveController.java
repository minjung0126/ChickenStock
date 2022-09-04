package com.chicken.project.receive.controller;

import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import com.chicken.project.receive.model.dto.ReceiveOfficeItemDTO;
import com.chicken.project.receive.model.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
        for(int i = 0; i < receiveOfficeList.size(); i++){
            String recCode = receiveOfficeList.get(i).getRecCode();
//            List<ReceiveOfficeItemDTO> receiveOfficeItemList = receiveService.selectAllReceiveItem(recCode);
            ArrayList<List<ReceiveOfficeItemDTO>> receive = new ArrayList<>();
            receive.add(receiveService.selectAllReceiveItem(recCode));
            mv.addObject("receive", receive);
            System.out.println(receive);
        }

        for(ReceiveOfficeDTO receiveOffice : receiveOfficeList){
            System.out.println("receiveOffice = " + receiveOffice);

        }
        mv.addObject("receiveOfficeList", receiveOfficeList);
        mv.setViewName("receive/admin/admin_receive");

        return mv;
    }
}
