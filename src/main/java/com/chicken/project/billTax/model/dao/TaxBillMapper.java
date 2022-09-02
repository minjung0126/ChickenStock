package com.chicken.project.billTax.model.dao;

import com.chicken.project.billTax.model.dto.TaxBillDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaxBillMapper {

    List<TaxBillDTO> selectTaxBillList();
}
