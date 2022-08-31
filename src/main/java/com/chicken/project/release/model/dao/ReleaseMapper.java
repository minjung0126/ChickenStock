package com.chicken.project.release.model.dao;

import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReleaseMapper {
    List<ReleaseOrderDTO> releaseOrderSelect();
}
