package com.chicken.project.release.controller;

import com.chicken.project.release.model.dto.ReleaseDTO;
import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import com.chicken.project.release.model.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        List<ReleaseOrderDTO> orderListN = releaseService.releaseOrderSelectN();
        List<ReleaseOrderDTO> orderListY = releaseService.releaseOrderSelectY();
        List<ReleaseDTO> releaseDTO = releaseService.releaseDtoOrderSelect();

//        for(ReleaseOrderDTO order : orderListN){
//            System.out.println(order);
//        }
//
//        for(ReleaseOrderDTO order : orderListY){
//            System.out.println(order);
//        }
//
//        for(ReleaseDTO release : releaseDTO){
//            System.out.println(release);
//        }

        String relCode = null;
        if(!releaseDTO.isEmpty()){
            relCode = String.valueOf(releaseDTO.size()+1);
        }

//        System.out.println(relCode);

        mv.addObject("relCode", relCode);
        mv.addObject("releaseDTO",releaseDTO);
        mv.addObject("orderListN", orderListN);
        mv.addObject("orderListY", orderListY);
        mv.setViewName("release/release_order");

        return mv;
    }

    @PostMapping("/orderInsertUpdate")
    public String releaseInsertUpdate(@ModelAttribute ReleaseOrderDTO storeOrderDTO, @RequestParam("relCode") int relCode) {

        System.out.println(storeOrderDTO);
        System.out.println(relCode);

        int resultUpdate = releaseService.releaseItemUpdateY(storeOrderDTO);
        int resultInsert = releaseService.releaseItemInsert(storeOrderDTO, relCode);

        return "redirect:release/release_order";
    }
    @PostMapping("/orderDeleteUpdate")
    public String releaseDeleteUpdate(@ModelAttribute ReleaseOrderDTO storeOrderDTO, @RequestParam("relCode") int relCode) {

        System.out.println(storeOrderDTO);
        System.out.println(relCode);

        int resultInsert = releaseService.releaseItemUpdateN(storeOrderDTO);
        int resultDelete = releaseService.releaseItemDelete(storeOrderDTO, relCode);

        return "redirect:release/release_order";
    }
}
