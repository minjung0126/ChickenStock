package com.chicken.project.release.model.dao;

import com.chicken.project.release.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReleaseMapper {
    List<ReleaseOrderDTO> releaseOrderSelect(ReleaseSelectCriteria releaseSelectCriteria);
    List<ReleaseOrderDTO> releaseOrderSelectN();
    List<ReleaseDTO> releaseDtoOrderSelect();

    int releaseItemUpdateY(ReleaseCartDTO releaseCartDTO);
    
    int releaseItemUpdateN(ReleaseItemDTO releaseOrderDTO);

    int cartYnUpdateR(ReleaseCartDTO releaseCartDTO);

    int cartYnUpdateN(ReleaseCartDTO releaseCartDTO);

    Integer totalMoneySelect(Integer intRelCode);

    int releaseInsert(ReleaseDTO relDto);

    int releaseItemUpdateF();

    List<ReleaseDTO> releaseSelect();

    int releaseItemInsert(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, ReleaseCartDTO releaseCartDTO, int relCode, int totalItemMoney);
    int releaseItemDelete(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseCartDTO releaseCartDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, int relCode);

    List<ReleaseOrderDTO> releaseItemListSelect(int relCode);

    List<ReleaseOrderDTO> releaseItemListSelect2(int relCode);

    int itemAmountUpdate(Map<String, Integer> itemAmountUpdate);

    int relItemHistoryInsert(Map<String, Integer> itemAmountUpdate);

    int relAmountSumSelect(int relCodeDetail);



}
