package com.chicken.project.billTax.model.service;

import com.chicken.project.billTax.model.dao.TaxBillMapper;
import com.chicken.project.billTax.model.dto.TaxBillDTO;
import com.chicken.project.billTax.model.dto.TsBillDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("taxBillService")
public class TaxBillService {

    private final TaxBillMapper taxbillMapper;

    public TaxBillService(TaxBillMapper taxbillMapper) {
        this.taxbillMapper = taxbillMapper;
    }

//    가맹점 세금계산서
    public List<TaxBillDTO> selectTaxBillList() {

        return taxbillMapper.selectTaxBillList();
    }
//    본사 세금계산서
    public List<TaxBillDTO> selectBillTaxList() {

        return taxbillMapper.selectTaxBillList();
    }
//    가맹점 거래명세서
    public List<TsBillDTO> selectTsList() {

        return taxbillMapper.selectTsBillList();
    }

//    본사 거래명세서
    public List<TsBillDTO> selectTsTaxList() {

        return taxbillMapper.selectTsBillList();
    }

}
