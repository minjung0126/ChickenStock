package com.chicken.project.counsel.controller;

import com.chicken.project.counsel.model.dto.CounselDTO;
import com.chicken.project.counsel.model.service.CounselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/counsel/*")
public class CounselController {

    private final CounselService counselService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CounselController(CounselService counselService){

        this.counselService = counselService;
    }

    @GetMapping("/user/list")
    public ModelAndView counselListPage(ModelAndView mv){

        log.info("[CounselController] counsel : ");

        List<CounselDTO> counselList = counselService.selectCounsel();

        mv.addObject("counselList", counselList);
        mv.setViewName("/counsel/user/userCounselList");

        return mv;
    }

    @GetMapping("/user/insert")
    public String counselInsertPage(){

        return "/counsel/user/userCounselInsert";
    }

    @PostMapping("/user/insert")
    public String counselInsert(@ModelAttribute CounselDTO counsel, RedirectAttributes rttr, ModelAndView mv){

        log.info("[CounselController] counsel : " + counsel);

        counselService.insertCounsel(counsel);

        mv.addObject("counsel", counsel);
        rttr.addFlashAttribute("message", "1:1 문의 등록 성공!");

        return "redirect:/counsel/user/list";
    }
}
