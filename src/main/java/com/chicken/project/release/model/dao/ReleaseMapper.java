package com.chicken.project.release.model.dao;

import com.chicken.project.release.model.dto.ReleaseDTO;
import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReleaseMapper {
    List<ReleaseOrderDTO> releaseOrderSelectN();
    List<ReleaseOrderDTO> releaseOrderSelectY();
    List<ReleaseDTO> releaseDtoOrderSelect();

    int releaseItemUpdateY(ReleaseOrderDTO storeOrderDTO);

    int releaseItemInsert(ReleaseOrderDTO storeOrderDTO, int relCode, int totalItemMoney);

    int releaseItemUpdateN(ReleaseOrderDTO storeOrderDTO);

    int releaseItemDelete(ReleaseOrderDTO storeOrderDTO, int relCode);

    Integer totalMoneySelect(Integer intRelCode);

    int releaseInsert(ReleaseDTO relDto);

    int releaseItemUpdateF();

    List<ReleaseDTO> releaseSelect();

    List<ReleaseOrderDTO> releaseItemListSelect();
}
