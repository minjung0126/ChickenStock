package com.chicken.project.storeReceive.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.storeReceive.model.dto.RecReleaseDTO;
import com.chicken.project.storeReceive.model.dto.RecReleaseItemDTO;
import com.chicken.project.storeReceive.model.dto.RecStoreOrderDTO;
import com.chicken.project.storeReceive.model.dto.ReceiveStoreDTO;

import java.util.List;
import java.util.Map;

public interface StoreReceiveService {


    int selectTotalCount(Map<String, String> searchMap);

    List<RecReleaseDTO> selectAllRelease(SelectCriteria selectCriteria);

    List<RecReleaseItemDTO> selectAllItem(String relCode);
}
