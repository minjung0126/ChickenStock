package com.chicken.project.release.model.service;

import com.chicken.project.release.model.dto.ReleaseDTO;
import com.chicken.project.release.model.dto.ReleaseOrderDTO;

import java.util.List;

public interface ReleaseService {
    List<ReleaseOrderDTO> releaseOrderSelectN();

    List<ReleaseOrderDTO> releaseOrderSelectY();

    List<ReleaseDTO> releaseDtoOrderSelect();

    int releaseItemUpdateY(ReleaseOrderDTO storeOrderDTO);
    int releaseItemInsert(ReleaseOrderDTO storeOrderDTO, int relCode);

    int releaseItemUpdateN(ReleaseOrderDTO storeOrderDTO);

    int releaseItemDelete(ReleaseOrderDTO storeOrderDTO, int relCode);
}
