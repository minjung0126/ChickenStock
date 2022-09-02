package com.chicken.project.billtax.model.dao;

import com.chicken.project.billtax.model.dto.TaxBillDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaxBillMapper {

    List<TaxBillDTO> selectTaxBillList();
}
