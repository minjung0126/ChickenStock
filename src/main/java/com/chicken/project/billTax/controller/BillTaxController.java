package com.chicken.project.billTax.controller;

import com.chicken.project.billTax.model.dto.TaxBillDTO;
import com.chicken.project.billTax.model.service.TaxBillService;
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
}
