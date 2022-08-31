package com.chicken.project.receive.model.dao;

import com.chicken.project.receive.model.dto.ReceiveOfficeDTO;

import java.util.List;

public interface ReceiveMapper {
    List<ReceiveOfficeDTO> selectAllList();
}
