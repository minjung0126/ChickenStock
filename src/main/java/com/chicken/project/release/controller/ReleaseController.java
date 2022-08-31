package com.chicken.project.release.controller;

import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import com.chicken.project.release.model.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/release")
public class ReleaseController {

    private final ReleaseService releaseService;
    @Autowired
    public ReleaseController(ReleaseService releaseService) {

        this.releaseService = releaseService;
    }

    @GetMapping("/orderSelect")
    public ModelAndView releaseOrderSelect(ModelAndView mv, Model model){

        List<ReleaseOrderDTO> orderList = releaseService.releaseOrderSelect();

//        for(ReleaseOrderDTO order : orderList){
//            System.out.println(order);
//        }

        mv.addObject("orderList", orderList);
        mv.setViewName("release/release_order");

        return mv;
    }
}
