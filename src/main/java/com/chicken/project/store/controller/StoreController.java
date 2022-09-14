package com.chicken.project.store.controller;

import com.chicken.project.exception.store.StoreDeleteException;
import com.chicken.project.exception.store.StoreInsertException;
import com.chicken.project.exception.store.StoreUpdateException;
import com.chicken.project.store.model.dto.StoreDTO;
import com.chicken.project.store.model.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/store/*")
public class StoreController {

    private final StoreService storeService;
   // private final PasswordEncoder passwordEncoder;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
    public String deleteStore(HttpServletRequest request, RedirectAttributes rttr) throws Exception {

        String storeName = request.getParameter("storeName");

        storeService.deleteStore(storeName);

        rttr.addFlashAttribute("message", "가맹점 정보 삭제 성공!");

        return "redirect:/store/admin/list";
    }

    @GetMapping("/admin/insert")
    public String insertStorePage(){

        return "/store/admin/adminStoreInsert";
    }

    @PostMapping("/admin/insert")
    public String insertStore(@ModelAttribute StoreDTO store, RedirectAttributes rttr, ModelAndView mv) throws StoreInsertException {

        store.setStorePhone(store.getStorePhone().replace("-", ""));
        //store.setStorePwd(passwordEncoder.encode(store.getStorePwd()));

        log.info("[StoreController] store : " + store);

        storeService.insertStore(store);

        rttr.addFlashAttribute("message", "가맹점 등록 성공!");

        mv.addObject("store", store);

        return "redirect:/store/admin/list";
    }

    @GetMapping("/admin/update")
    public ModelAndView updateStorePage(HttpServletRequest request, RedirectAttributes rttr, ModelAndView mv){

        String storeName = request.getParameter("storeName");

        log.info("[StoreController] storeName : " + storeName);

        StoreDTO store = storeService.selectStoreByName(storeName);

        mv.addObject("store", store);
        mv.setViewName("/store/admin/adminStoreUpdate");

        return mv;
    }

    @PostMapping("/admin/update")
    public String updateStore(@ModelAttribute StoreDTO store, RedirectAttributes rttr) throws StoreUpdateException {

        log.info("[StoreController] store : " + store);
        log.info("[StoreController] storeId : " + store.getStoreId());

        storeService.updateStore(store);

        rttr.addFlashAttribute("message", "가맹점 정보 수정 성공!");

        return "redirect:/store/admin/list";
    }

}
