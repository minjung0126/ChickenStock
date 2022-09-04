package com.chicken.project.counsel.model.dao;

import com.chicken.project.counsel.model.dto.CounselDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CounselMapper {
    int insertCounsel(CounselDTO counsel);

    List<CounselDTO> selectCounsel();
}
