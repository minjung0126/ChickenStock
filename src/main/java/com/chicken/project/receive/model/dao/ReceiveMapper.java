package com.chicken.project.receive.model.dao;

import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReceiveMapper {
    List<ReceiveOfficeDTO> selectAllList();
}
