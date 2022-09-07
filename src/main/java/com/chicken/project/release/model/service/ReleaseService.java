package com.chicken.project.release.model.service;

import com.chicken.project.release.model.dto.*;

import java.util.List;
import java.util.Map;

public interface ReleaseService {

    List<ReleaseOrderDTO> releaseOrderSelect(ReleaseSelectCriteria releaseSelectCriteria);
    List<ReleaseOrderDTO> releaseOrderSelectN();

    List<ReleaseDTO> releaseDtoOrderSelect();


    Integer totalMoneySelect(Integer intRelCode);

    int releaseInsert(ReleaseDTO relDto);

    int cartYnUpdateR(ReleaseCartDTO releaseCartDTO);

    int releaseItemUpdateN(ReleaseItemDTO releaseItemDTO);

    int cartYnUpdateN(ReleaseCartDTO releaseCartDTO);

    int releaseItemUpdateF();

    List<ReleaseDTO> releaseSelect();

    int releaseItemInsert(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, ReleaseCartDTO releaseCartDTO, int relCode, int totalItemMoney);

    int releaseItemDelete(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseCartDTO releaseCartDTO, ReleaseItemDTO releaseItemDTO, StoreOrderDTO storeOrderDTO, int relCode);

    List<ReleaseOrderDTO> releaseItemListSelect(int relCode);

    List<ReleaseOrderDTO> releaseSelect2(int relCode);

    int itemAmountUpdate(Map<String, Integer> itemAmountUpdate);

    int relItemHistoryInsert(Map<String, Integer> itemAmountUpdate);

    int relAmountSumSelect(int relCodeDetail);



}
