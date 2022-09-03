package com.chicken.project.billTax.model.service;

import com.chicken.project.billTax.model.dao.BillTaxMapper;
import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("billTaxService")
public class BillTaxService {

    public BillTaxMapper billTaxMapper;

    public BillTaxService(BillTaxMapper billTaxMapper) {
      this.billTaxMapper = billTaxMapper;
    }
    public List<BillTaxDTO> selectTaxBillList(SelectCriteria selectCriteria) {

        List<BillTaxDTO> billTaxList = billTaxMapper.selectBillTaxList(selectCriteria);

        return billTaxList;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result =billTaxMapper.selectTotalCount(searchMap);

        return result;
    }

    public List<BillTaxDTO> selectTaxMenuList(String recCode) {

        return billTaxMapper.selectTaxMenuList(recCode);
    }
}
