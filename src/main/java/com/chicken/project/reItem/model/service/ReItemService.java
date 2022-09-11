package com.chicken.project.reItem.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.reItem.model.dao.ReItemMapper;
import com.chicken.project.reItem.model.dto.ReItemDTO;
import com.chicken.project.reItem.model.dto.ReListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("reItemService")
public class ReItemService {

    public ReItemMapper reItemMapper;

    public ReItemService(ReItemMapper reItemMapper) { this.reItemMapper = reItemMapper; }

    // 페이징
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = reItemMapper.selectTotalCount(searchMap);

        return result;
    }

    public List<ReListDTO> selectReList(SelectCriteria selectCriteria) {

        List<ReListDTO> reList = reItemMapper.selectReList(selectCriteria);

        return reList;
    }

    public List<ReListDTO> selectReturnList(SelectCriteria selectCriteria) {

        List<ReListDTO> returnList = reItemMapper.selectReturnList(selectCriteria);

        return returnList;
    }

    public ReItemDTO selectReturnItem(String rNo) {

        ReItemDTO reItem = reItemMapper.selectReturnItem(rNo);

        return reItem;
    }

    public List<ReItemDTO> selectReturnItemS(String rNo) {

        List<ReItemDTO> reItems = reItemMapper.selectReItems(rNo);

        return reItems;
    }
}
