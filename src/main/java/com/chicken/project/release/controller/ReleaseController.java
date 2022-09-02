package com.chicken.project.release.controller;

import com.chicken.project.release.model.dto.ItemInfoDTO;
import com.chicken.project.release.model.dto.ReleaseDTO;
import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import com.chicken.project.release.model.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
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

        List<ReleaseOrderDTO> orderListN = releaseService.releaseOrderSelectN();
        List<ReleaseOrderDTO> orderListY = releaseService.releaseOrderSelectY();
        List<ReleaseDTO> releaseDTO = releaseService.releaseDtoOrderSelect();


        String relCode = null;
        if(!releaseDTO.isEmpty()){
            relCode = String.valueOf(releaseDTO.size()+1);
        }

        int intRelCode = Integer.parseInt(relCode);
        Integer totalMoney = releaseService.totalMoneySelect(intRelCode);

        mv.addObject("totalMoney", totalMoney);
        mv.addObject("relCode", relCode);
        mv.addObject("releaseDTO",releaseDTO);
        mv.addObject("orderListN", orderListN);
        mv.addObject("orderListY", orderListY);
        mv.setViewName("release/release_order");

        return mv;
    }

    @PostMapping("/orderInsertUpdate")
    public ModelAndView releaseInsertUpdate(@ModelAttribute ReleaseOrderDTO storeOrderDTO,
                                            @ModelAttribute ItemInfoDTO itemInfoDTO,
                                            @RequestParam("relCode") int relCode,
                                            ModelAndView mv) {

//        System.out.println(storeOrderDTO);
//        System.out.println(relCode);

        int itemSales = Integer.parseInt(itemInfoDTO.getItemSales());
        int orderAmount = storeOrderDTO.getOrderAmount();
        int totalItemMoney = itemSales * orderAmount;

//        System.out.println("itemSales = " + itemSales);
//        System.out.println("orderAmount = " + orderAmount);
//        System.out.println("totalItemMoney = " + totalItemMoney);

        int resultUpdate = releaseService.releaseItemUpdateY(storeOrderDTO);
        int resultInsert = releaseService.releaseItemInsert(storeOrderDTO, relCode, totalItemMoney);

        mv.setViewName("redirect:/release/orderSelect");

        return mv;
    }
    @PostMapping("/orderDeleteUpdate")
    public ModelAndView releaseDeleteUpdate(@ModelAttribute ReleaseOrderDTO storeOrderDTO,
                                            @RequestParam("relCode") int relCode,
                                            ModelAndView mv) {

        System.out.println(storeOrderDTO);
        System.out.println(relCode);

        int resultInsert = releaseService.releaseItemUpdateN(storeOrderDTO);
        int resultDelete = releaseService.releaseItemDelete(storeOrderDTO, relCode);

        mv.setViewName("redirect:/release/orderSelect");
        return mv;
    }

    @PostMapping("/releaseInsertUpdate")
    public ModelAndView releaseInsert(ModelAndView mv, @ModelAttribute ReleaseDTO relDto){

        System.out.println(relDto);

        int releaseInsert = releaseService.releaseInsert(relDto);
        int resultUpdate = releaseService.releaseItemUpdateF();

        mv.setViewName("redirect:/release/orderSelect");
        return mv;
    }

    @GetMapping("/releaseSelect")
    public ModelAndView releaseSelect(ModelAndView mv){

        List<ReleaseDTO> releaseSelect = releaseService.releaseSelect();
        List<ReleaseOrderDTO> releaseItemListSelect = releaseService.releaseItemListSelect();

        for(ReleaseDTO relList : releaseSelect){
            System.out.println(relList);
        }

        for(ReleaseOrderDTO relListSelect : releaseItemListSelect){
            System.out.println(relListSelect);
        }

        mv.addObject("releaseSelect", releaseSelect);
        mv.setViewName("release/release_list");
        return mv;
    }
}
