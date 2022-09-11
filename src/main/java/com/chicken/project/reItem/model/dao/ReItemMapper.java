package com.chicken.project.reItem.model.dao;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.reItem.model.dto.ReItemDTO;
import com.chicken.project.reItem.model.dto.ReListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReItemMapper {

    // 페이징
    int selectTotalCount(Map<String, String> searchMap);

    // 가맹점 반품서 리스트
    List<ReListDTO> selectReList(SelectCriteria selectCriteria);

    // 본사로 들어온 반품서 리스트
    List<ReListDTO> selectReturnList(SelectCriteria selectCriteria);

    ReItemDTO selectReturnItem(String rNo);

    List<ReItemDTO> selectReItems(String rNo);
}
