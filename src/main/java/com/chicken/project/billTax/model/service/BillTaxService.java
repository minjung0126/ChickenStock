package com.chicken.project.billTax.model.service;

import com.chicken.project.billTax.model.dao.BillTaxMapper;
import com.chicken.project.billTax.model.dto.BillTaxDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billTaxService")
public class BillTaxService {

    public BillTaxMapper billTaxMapper;

    public BillTaxService(BillTaxMapper billTaxMapper) {
      this.billTaxMapper = billTaxMapper;
    }
    public List<BillTaxDTO> selectTaxBillList() {

        return billTaxMapper.selectBillTaxList();
    }
}
