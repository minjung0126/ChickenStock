package com.chicken.project.item.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.item.ItemInsertException;
import com.chicken.project.exception.item.ItemUpdateException;
import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ItemService {

    int selectTotalCount(Map<String, String> searchMap);

    List<ItemInfoDTO> selectAllItem(SelectCriteria selectCriteria);

    List<ItemCategoryDTO> selectPreCategory();

    List<ItemCategoryDTO> selectCategory();

    @Transactional
    int insertItem(ItemInfoDTO item) throws ItemInsertException;

    @Transactional
    int deleteItem(String itemNo) throws ItemUpdateException;

    @Transactional
    int deleteItemFile(String itemNo) throws ItemUpdateException;

    @Transactional
    int insertFileRegist(ItemFileDTO itemFile) throws ItemUpdateException;

    @Transactional
    int insertItemHistory() throws ItemInsertException;

    ItemInfoDTO selectOneItem(String itemNoInput);
}
