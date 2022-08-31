package com.chicken.project.release.model.service;

import com.chicken.project.release.model.dto.ReleaseOrderDTO;

import java.util.List;

public interface ReleaseService {
    List<ReleaseOrderDTO> releaseOrderSelect();
}
