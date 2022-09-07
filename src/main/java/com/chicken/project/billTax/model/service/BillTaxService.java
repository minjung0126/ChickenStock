package com.chicken.project.billTax.model.service;

import com.chicken.project.billTax.model.dao.BillTaxMapper;
import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.billTax.model.dto.tsBillTaxDTO;
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

    // 세금계산서 페이징+리스트
    public List<BillTaxDTO> selectTaxBillList(SelectCriteria selectCriteria) {

        List<BillTaxDTO> billTaxList = billTaxMapper.selectBillTaxList(selectCriteria);

        return billTaxList;
    }

    // 페이징을 위한 전체 게시글 카운트
    public int selectTotalCount(Map<String, String> searchMap) {

        int result =billTaxMapper.selectTotalCount(searchMap);

        return result;
    }

    // 세금계산서별 물품리스트
    public List<BillTaxDTO> selectTaxMenuList(String recCode) {

        return billTaxMapper.selectTaxMenuList(recCode);
    }

    // 거래명세서 페이징+리스트
    public List<tsBillTaxDTO> selectTsBillTaxList(SelectCriteria selectCriteria) {

        List<tsBillTaxDTO> tsBillTaxList = billTaxMapper.selectTsBillTaxList(selectCriteria);

        return tsBillTaxList;
    }

    // 거래명세서별 물품리스트
    public List<tsBillTaxDTO> selectTsMenuList(String recCode) {

        return billTaxMapper.selectTsMenuList(recCode);
    }
}
