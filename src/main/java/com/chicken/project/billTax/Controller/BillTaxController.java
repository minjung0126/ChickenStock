package com.chicken.project.billTax.Controller;

import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.billTax.model.service.BillTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/billTax/*")
public class BillTaxController {

    private final BillTaxService billTaxService;

    @Autowired
    public BillTaxController(BillTaxService billTaxService){
        this.billTaxService = billTaxService;
    }

    @GetMapping("/billList")
    public ModelAndView billList(ModelAndView mv) {
        List<BillTaxDTO> taxBillList = billTaxService.selectTaxBillList();
        mv.addObject("taxBillList", taxBillList);
        mv.setViewName("billTax/billList");

        return mv;
    }
}
