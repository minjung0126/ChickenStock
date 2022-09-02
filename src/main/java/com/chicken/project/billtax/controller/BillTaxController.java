package com.chicken.project.billtax.controller;

import com.chicken.project.billtax.model.dto.TaxBillDTO;
import com.chicken.project.billtax.model.service.TaxBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/billTax/*")
public class BillTaxController {

    private final TaxBillService taxbillService;

    @Autowired
    public BillTaxController(TaxBillService taxbillService) {
        this.taxbillService = taxbillService;

    }

    @GetMapping("/billList")
    public ModelAndView billList(ModelAndView mv){

        List<TaxBillDTO> taxBillList = taxbillService.selectTaxBillList();

        mv.addObject("taxBillList", taxBillList);
        mv.setViewName("billTax/billList");

        return mv;
    }
    @GetMapping("/billtaxList")
    public ModelAndView billTaxList(ModelAndView mv){

        List<TaxBillDTO> taxBillList = taxbillService.selectBillTaxList();

        mv.addObject("billTaxList", taxBillList);
        mv.setViewName("billTax/billtaxList");

        return mv;
    }
}
