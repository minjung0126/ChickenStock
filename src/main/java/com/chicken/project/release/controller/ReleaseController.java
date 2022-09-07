package com.chicken.project.release.controller;

import com.chicken.project.release.model.dto.ReleaseSelectCriteria;
import com.chicken.project.release.model.dto.*;
import com.chicken.project.release.model.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/release")
public class ReleaseController {

    private final ReleaseService releaseService;
    @Autowired
    public ReleaseController(ReleaseService releaseService) {

        this.releaseService = releaseService;
    }

    @RequestMapping("/orderSelect")
    public ModelAndView releaseOrderSelect(ModelAndView mv, Model model, @ModelAttribute ReleaseSelectCriteria releaseSelectCriteria){

        System.out.println(releaseSelectCriteria);

        List<ReleaseOrderDTO> orderList = releaseService.releaseOrderSelect(releaseSelectCriteria);
        List<ReleaseOrderDTO> orderListN = releaseService.releaseOrderSelectN();
        List<ReleaseDTO> releaseDTO = releaseService.releaseDtoOrderSelect();

        String relCode = null;
        if(!releaseDTO.isEmpty()){
            relCode = String.valueOf(releaseDTO.size()+1);
        }

        System.out.println("relCode : " + relCode);
        System.out.println(releaseSelectCriteria);
        for(ReleaseOrderDTO ro : orderListN){
            System.out.println(ro);
        }

        int intRelCode = Integer.parseInt(relCode);
        Integer totalMoney = releaseService.totalMoneySelect(intRelCode);

        mv.addObject("orderList", orderList);
        mv.addObject("orderListN", orderListN);
        mv.addObject("releaseSelectCriteria", releaseSelectCriteria);
        mv.addObject("totalMoney", totalMoney);
        mv.addObject("relCode", relCode);
        mv.addObject("releaseDTO",releaseDTO);

        mv.setViewName("release/release_order");

        return mv;
    }

    @PostMapping("/orderInsertUpdate")
    public ModelAndView releaseInsertUpdate(@ModelAttribute ReleaseItemInfoDTO releaseItemInfoDTO,
                                            @ModelAttribute ReleaseItemDTO releaseItemDTO,
                                            @ModelAttribute ReleaseCartDTO releaseCartDTO,
                                            @ModelAttribute StoreOrderDTO storeOrderDTO,
                                            @RequestParam("relCode") int relCode,
                                            ModelAndView mv) {

        System.out.println("releaseItemInfoDTO = " + releaseItemInfoDTO);
        System.out.println("ReleaseItemDTO = " + releaseItemDTO);
        System.out.println("releaseCartDTO = " + releaseCartDTO);
        System.out.println("StoreOrderDTO = " + storeOrderDTO);
        System.out.println("relCode" + relCode);

        int itemSales = Integer.parseInt(releaseItemInfoDTO.getItemSales());
        int orderAmount = releaseCartDTO.getCartAmount();
        int totalItemMoney = itemSales * orderAmount;

        System.out.println("itemSales = " + itemSales);
        System.out.println("orderAmount = " + orderAmount);
        System.out.println("totalItemMoney = " + totalItemMoney);

        int resultUpdate = releaseService.cartYnUpdateR(releaseCartDTO);
        int resultInsert = releaseService.releaseItemInsert(releaseItemInfoDTO, releaseItemDTO, storeOrderDTO, releaseCartDTO, relCode, totalItemMoney);

        mv.setViewName("redirect:/release/orderSelect");

        return mv;
    }
    @PostMapping("/orderDeleteUpdate")
    public ModelAndView releaseDeleteUpdate(@ModelAttribute ReleaseItemInfoDTO releaseItemInfoDTO,
                                            @ModelAttribute ReleaseItemDTO releaseItemDTO,
                                            @ModelAttribute ReleaseCartDTO releaseCartDTO,
                                            @ModelAttribute StoreOrderDTO storeOrderDTO,
                                            @RequestParam("relCode") int relCode,
                                            ModelAndView mv) {

        System.out.println("StoreOrderDTO = " + storeOrderDTO);
        System.out.println("releaseItemInfoDTO = " + releaseItemInfoDTO);
        System.out.println("releaseItemDTO = " + releaseItemDTO);
        System.out.println("releaseCartDTO = " + releaseCartDTO);
        System.out.println("relCode" + relCode);

        int resultUpdate  = releaseService.releaseItemUpdateN(releaseItemDTO);
        int resultUpdate2 = releaseService.cartYnUpdateN(releaseCartDTO);
        int resultDelete = releaseService.releaseItemDelete(releaseItemInfoDTO, releaseCartDTO, releaseItemDTO, storeOrderDTO, relCode);

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

        List<List<ReleaseOrderDTO>> releaseSelectItem = new ArrayList<>();
        for(int i = 0; i < releaseSelect.size(); i++){

            int relCode = releaseSelect.get(i).getRelCode();
            List<ReleaseOrderDTO> releaseSelect2 = releaseService.releaseSelect2(relCode);

        }


        mv.addObject("releaseSelect", releaseSelect);
        mv.addObject("releaseSelectItem", releaseSelectItem);
        mv.setViewName("release/release_list");
        return mv;
    }

    @PostMapping("/releaseItem")
    public ModelAndView releaseItemInsertUpdate(ModelAndView mv, @RequestParam("itemAmount") int itemAmount,
                                                                 @RequestParam("cartAmount") int cartAmount,
                                                                 @RequestParam("itemNo") int itemNo,
                                                                 @RequestParam("relCode") int relCode,
                                                                 @RequestParam("relCodeDetail") int relCodeDetail,
                                                                 @RequestParam("relAmount") int relAmount){

        int amountUpdate = itemAmount - relAmount;

        System.out.println("itemAmount : " + itemAmount);
        System.out.println("cartAmount : " + cartAmount);
        System.out.println("relAmount : " + relAmount);
        System.out.println("itemNo : " + itemNo);
        System.out.println("itemAmountUpdate : " + amountUpdate);
        System.out.println("relCode : " + relCode);
        System.out.println("relCodeDetail : " + relCodeDetail);

        Map<String, Integer> itemAmountUpdate = new HashMap<>();
        itemAmountUpdate.put("itemAmount", itemAmount);
        itemAmountUpdate.put("cartAmount", cartAmount);
        itemAmountUpdate.put("relAmount", relAmount);
        itemAmountUpdate.put("amountUpdate", amountUpdate);
        itemAmountUpdate.put("itemNo", itemNo);
        itemAmountUpdate.put("relCode", relCode);
        itemAmountUpdate.put("relCodeDetail", relCodeDetail);
        System.out.println("itemAmountInsert : " + itemAmountUpdate);

        int result1 = releaseService.itemAmountUpdate(itemAmountUpdate);
        int result2 = releaseService.relItemHistoryInsert(itemAmountUpdate);

        mv.setViewName("redirect:/release/releaseSelect");
        return mv;
    }
}
