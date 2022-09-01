package com.chicken.project.billTax.model.service;

import com.chicken.project.billTax.model.dao.TaxBillMapper;
import com.chicken.project.billTax.model.dto.TaxBillDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taxBillService")
public class TaxBillService {

    private final TaxBillMapper taxbillMapper;

    public TaxBillService(TaxBillMapper taxbillMapper) {
        this.taxbillMapper = taxbillMapper;
    }

    public List<TaxBillDTO> selectTaxBillList() {

        return taxbillMapper.selectTaxBillList();
    }
}
