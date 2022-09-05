package com.chicken.project.billTax.Controller;

import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.billTax.model.service.BillTaxService;
import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/billTax/*")
public class BillTaxController {

    private final BillTaxService billTaxService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BillTaxController(BillTaxService billTaxService){

        this.billTaxService = billTaxService;
    }

    @GetMapping("/billList")
    public ModelAndView billList(ModelAndView mv, HttpServletRequest request) {

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
            if(pageNo <= 0) {

                pageNo = 1;
            }
        }
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[BillTaxController] searchMap = " + searchMap);

        int totalCount = billTaxService.selectTotalCount(searchMap);
        log.info("[BillTaxController] totalCount = " + totalCount);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[taxBillController] selectCriteria = " + selectCriteria);

        List<BillTaxDTO> taxBillList = billTaxService.selectTaxBillList(selectCriteria);

        //String recCode = taxBillList.get(0).getRecCode();
//        String recCode = "SI0001";
        Map<String, List<BillTaxDTO>> map = new HashMap<>();

        for(int i = 0; i < taxBillList.size(); i++){
            String recCode = taxBillList.get(i).getRecCode();
            List<BillTaxDTO> taxListMenu = billTaxService.selectTaxMenuList(recCode);

            map.put(recCode, taxListMenu);
        }

        // List<BillTaxDTO> taxListMenu = billTaxService.selectTaxMenuList(recCode);

        log.info("[taxBillController] taxBillList = " + taxBillList);
        log.info("[taxBillController] map = " + map);
        //log.info("[taxBillController] recCode = " + recCode);

        mv.addObject("taxBillList", taxBillList);
        mv.addObject("taxListMenu", map);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("billTax/billList");

        return mv;
    }
}