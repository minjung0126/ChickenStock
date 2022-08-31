package com.chicken.project.store.controller;

import com.chicken.project.exception.store.StoreDeleteException;
import com.chicken.project.store.model.dto.StoreDTO;
import com.chicken.project.store.model.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/store/*")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){

        this.storeService = storeService;
    }

    @GetMapping("/admin/list")
    public ModelAndView storeListPage(ModelAndView mv){

        List<StoreDTO> storeList = storeService.storeList();

        mv.addObject("storeList", storeList);
        mv.setViewName("/store/admin/adminStoreList");

        return mv;
    }

    @GetMapping("/user/list")
    public ModelAndView userStoreListPage(ModelAndView mv){

        List<StoreDTO> storeList = storeService.storeList();

        mv.addObject("storeList", storeList);
        mv.setViewName("/store/user/userStoreList");

        return mv;
    }

    @GetMapping("/admin/delete")
    public String deleteStore(HttpServletRequest request, RedirectAttributes rttr) throws StoreDeleteException {

        String storeName = request.getParameter("storeName");

        storeService.deleteStore(storeName);

        rttr.addFlashAttribute("message", "가맹점 정보 삭제에 성공하였습니다.");

        return "redirect:/store/admin/list";
    }
}
