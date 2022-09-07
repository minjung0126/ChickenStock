package com.chicken.project.counsel.controller;

import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import com.chicken.project.counsel.model.service.CounselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView userCounselListPage(ModelAndView mv, HttpServletRequest request){

        String storeId = request.getParameter("storeId");

        log.info("[CounselController] storeId : " + storeId);

        List<CounselDTO> counselList = counselService.selectCounselByStoreId(storeId);

        mv.addObject("counselList", counselList);
        mv.setViewName("/counsel/user/userCounselList");

        return mv;
    }

    @GetMapping("/admin/list")
    public ModelAndView adminCounselListPage(ModelAndView mv){

        List<CounselDTO> counselList = counselService.selectCounsel();

        mv.addObject("counselList", counselList);
        mv.setViewName("/counsel/admin/adminCounselList");

        return mv;
    }

    @GetMapping("/user/insert")
    public String counselInsertPage(){

        return "/counsel/user/userCounselInsert";
    }

    @PostMapping("/user/insert")
    public String userCounselInsert(@ModelAttribute CounselDTO counsel, RedirectAttributes rttr, ModelAndView mv){

        log.info("[CounselController] counsel : " + counsel);

        counselService.insertCounsel(counsel);

        mv.addObject("counsel", counsel);
        rttr.addFlashAttribute("message", "1:1 문의 등록 성공!");

        return "redirect:/counsel/user/list";
    }

    @GetMapping("/admin/detail")
    public ModelAndView adminCounselDetail(ModelAndView mv, @RequestParam int counselNo){

        log.info("[CounselController] counselNo : " + counselNo);

        CounselDTO counsel = counselService.selectCounselByNo(counselNo);
        CounselApplyDTO counselApply = counselService.selectCounselApplyByNo(counselNo);

        mv.addObject("counsel", counsel);
        mv.addObject("counselApply", counselApply);
        mv.setViewName("/counsel/admin/adminCounselDetail");

        return mv;
    }

    @GetMapping("/admin/insert")
    public ModelAndView adminCounselInsertPage(ModelAndView mv, HttpServletRequest request){

        int counselNo = Integer.parseInt(request.getParameter("counselNo"));

        log.info("[CounselController] counselNo : " + counselNo);

        CounselDTO counsel = counselService.selectCounselByNo(counselNo);

        log.info("[CounselController] counsel : " + counsel);

        mv.addObject("counsel", counsel);
        mv.setViewName("/counsel/admin/adminCounselInsert");

        return mv;
    }

    @PostMapping("/admin/insert")
    public String adminCounselInsert(@RequestParam String answerContent,
                                     HttpServletRequest request,
                                     ModelAndView mv,
                                     RedirectAttributes rttr){

        int counselNo = Integer.parseInt(request.getParameter("counselNo"));

        log.info("[CounselController] counselNo : " + counselNo);

        counselService.insertCounselApply(answerContent, counselNo);

        rttr.addFlashAttribute("message", "1:1문의 답변 등록 완료!");

        return "redirect:/counsel/admin/list";
    }

    @GetMapping("/user/detail")
    public ModelAndView userCounselPage(ModelAndView mv, @RequestParam int counselNo){

        log.info("[CounselController] couneslNo : " + counselNo);

        CounselDTO counsel = counselService.selectCounselByNo(counselNo);
        CounselApplyDTO counselApply = counselService.selectCounselApplyByNo(counselNo);

        mv.addObject("counsel", counsel);
        mv.addObject("counselApply", counselApply);

        mv.setViewName("/counsel/user/userCounselDetail");

        return mv;

    }
}
