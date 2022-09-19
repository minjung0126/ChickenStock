package com.chicken.project.item.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.item.ItemInsertException;
import com.chicken.project.exception.item.ItemUpdateException;
import com.chicken.project.item.model.dao.ItemMapper;
import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("itemService")
public class ItemService2 {

    private final ItemMapper itemMapper;

    public ItemService2(ItemMapper itemMapper){

        this.itemMapper = itemMapper;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = itemMapper.selectTotalCount(searchMap);

        return result;
    }

    public List<ItemInfoDTO> selectAllItem(SelectCriteria selectCriteria) {

        List<ItemInfoDTO> itemList = itemMapper.selectAllItem(selectCriteria);
        return itemList;
    }

    public List<ItemCategoryDTO> selectPreCategory() {

        List<ItemCategoryDTO> itemPreCategoryList = itemMapper.selectPreCategory();
        return itemPreCategoryList;
    }

    public List<ItemCategoryDTO> selectCategory() {

        List<ItemCategoryDTO> itemCategoryList = itemMapper.selectCategory();
        return itemCategoryList;
    }

    @Transactional
    public int insertItem(ItemInfoDTO item) throws ItemInsertException {

        int result = itemMapper.insertItem(item);

        if(!(result > 0)){
            throw new ItemInsertException("상품 등록에 실패하셨습니다.");
        }

        return result;
    }

    @Transactional
    public int deleteItem(String itemNo) throws ItemUpdateException {

        int result = itemMapper.deleteItem(itemNo);

        if(!(result > 0)){
            throw new ItemUpdateException("상품 삭제에 실패하셨습니다.");
        }

        return result;
    }

    @Transactional
    public int deleteItemFile(String itemNo) throws ItemUpdateException {

        int result = itemMapper.deleteItemFile(itemNo);

        if(!(result > 0)){
            throw new ItemUpdateException("상품 이미지 삭제에 실패하셨습니다.");
        }

        return result;
    }

    @Transactional
    public int insertFileRegist(ItemFileDTO itemFile) throws ItemUpdateException{

        int result = itemMapper.insertFileRegist(itemFile);

        if(!(result > 0)){
            throw new ItemUpdateException("상품 이미지 등록에 실패하셨습니다.");
        }

        return result;
    }

    @Transactional
    public int insertItemHistory() throws ItemInsertException{

        int result = itemMapper.insertItemHistory();

        if(!(result > 0)){
            throw new ItemInsertException("상품 등록에 실패하셨습니다.");
        }

        return result;
    }

    public ItemInfoDTO selectOneItem(String itemNoInput) {

        ItemInfoDTO oneItem = itemMapper.selectOneItem(itemNoInput);
        return oneItem;
    }
}
