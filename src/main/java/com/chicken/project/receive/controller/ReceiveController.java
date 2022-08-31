package com.chicken.project.receive.controller;

import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import com.chicken.project.receive.model.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/receive/*")
public class ReceiveController {

    private final ReceiveService receiveService;

    @Autowired
    public ReceiveController(ReceiveService receiveService){

        this.receiveService = receiveService;
    }

    @GetMapping("/list")
    public ModelAndView receiveList(ModelAndView mv){

        List<ReceiveOfficeDTO> receiveList = receiveService.selectAllList();

        mv.addObject("receiveList", receiveList);
        mv.setViewName("receive/receive_list");

        return mv;
    }
}
