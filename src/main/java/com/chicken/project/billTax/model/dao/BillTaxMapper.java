package com.chicken.project.billTax.model.dao;

import com.chicken.project.billTax.model.dto.BillTaxDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillTaxMapper {
    List<BillTaxDTO> selectBillTaxList();
}
