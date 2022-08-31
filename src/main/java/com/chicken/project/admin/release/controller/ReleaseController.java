package com.chicken.project.admin.release.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/release")
public class ReleaseController {

    @GetMapping("/orderSelect")
    public ModelAndView releaseOrderSelect(ModelAndView mv){

        mv.setViewName("release/release_order");
        return mv;
    }
}
