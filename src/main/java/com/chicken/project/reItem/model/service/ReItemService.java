package com.chicken.project.reItem.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.reItem.model.dao.ReItemMapper;
import com.chicken.project.reItem.model.dto.ReItemDTO;
import com.chicken.project.reItem.model.dto.ReListDTO;
import com.chicken.project.reItem.model.dto.StoreItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reItemService")
public class ReItemService {

    public ReItemMapper reItemMapper;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ReItemService(ReItemMapper reItemMapper) { this.reItemMapper = reItemMapper; }

    // 페이징
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = reItemMapper.selectTotalCount(searchMap);

        return result;
    }

    // 가맹점 반품서 리스트보기
    public List<ReListDTO> selectReList(SelectCriteria selectCriteria) {


        List<ReListDTO> reList = reItemMapper.selectReList(selectCriteria);

        return reList;
    }

    public List<ReListDTO> selectReturnList(SelectCriteria selectCriteria) {

        List<ReListDTO> returnList = reItemMapper.selectReturnList(selectCriteria);

        return returnList;
    }

    // 본사 반품 상세보기
    public ReItemDTO selectReturnItem(String rNo) {

        ReItemDTO reItem = reItemMapper.selectReturnItem(rNo);

        return reItem;
    }


    public List<ReItemDTO> selectReturnItems(String rNo) {

        List<ReItemDTO> reItems = reItemMapper.selectReItems(rNo);

        return reItems;
    }

    public List<StoreItemDTO> selectItem(String storeName) {

        List<StoreItemDTO> storeItems = reItemMapper.selectItem(storeName);

        return storeItems;
    }

    // 가맹점 반품신청
    @Transactional
    public int insertReItem(List<ReItemDTO> insertItem, String storeName) {

        int result = 0;

        result = reItemMapper.insertReturnItems(insertItem.get(0));

        if(result > 0){

            log.info("result 확인 : " + result);
            result = 0; //초기화


            List<Map<String, Object>> reList = new ArrayList<>();
            for(int i =0; i < insertItem.size(); i++){
                Map<String, Object> maps = new HashMap<>();
                maps.put("returnCount", insertItem.get(i).getReturnCount());
                maps.put("itemNo", insertItem.get(i).getItemNo());
                maps.put("storeName", storeName);
                reList.add(maps);
                result = reItemMapper.insertRItem(maps);
            }

            if(result > 0) {

                result = 0;

                Map<String, Object> map = null;

                for(int i =0; i < reList.size(); i++) {

                    map = reList.get(i);

                    result = reItemMapper.updateAcount(map);
                }
                if (result > 0) {

                    result = 0;

                    result = reItemMapper.insertProgress(insertItem.get(0));
                }
            }
        }

        return result;
    }
    // 본사 반품승인
    @Transactional
    public int updateComplete(ReItemDTO returnItems, String adminId, String rNo, String storeName) {

        Map<String, Object> map = new HashMap<>();
        map.put("adminId", adminId);
        map.put("rNo", Integer.parseInt(rNo));

        int result = 0;

        result = reItemMapper.updateComplete(map);  //본사 progress update

        if(result > 0){

            result = 0;

            result = reItemMapper.updateProgress(Integer.parseInt(rNo));  // 대기 -> 반품완료

            if(result > 0){

                result = 0;

                Map<String, Object> maps = new HashMap<>();
                maps.put("rNo", Integer.parseInt(rNo));
                maps.put("storeName", storeName);
                maps.put("returnTotalMoney", returnItems.getReturnTotalMoney());

                result = reItemMapper.updateMoney(maps);    // 예치금 올려주기
            }

        }

        return result;
    }
    @Transactional
    public List<ReItemDTO> selectList(String rNo) {

        List<ReItemDTO> re = reItemMapper.selectRItem(rNo);

        return re;

    }

    public int updateItem(Map<String, Object> maps) {

        int result = 0;

        for (int i = 0; i < ((List<ReItemDTO>) maps.get("check")).size(); i++) {

            ReItemDTO reItem = ((List<ReItemDTO>) maps.get("check")).get(i);
            reItem.setrNo(Integer.parseInt((String) maps.get("rNo")));
            result = reItemMapper.upDateItem(reItem);


            if(result > 0){

                result = 0;

                result = reItemMapper.insertHistory(reItem);

                if(result > 0){

                    result = 0;

                    result = reItemMapper.updateRProgress(reItem);
                }
            }
            log.info("확인중입니다요"+reItem);
        }


        return result;
    }

    public int deleteList(String rNo) {

        int result = 0;

        result = reItemMapper.deleteProgress(rNo);

        if(result > 0 ){

            result = 0;

            result = reItemMapper.deleteRItem(rNo);

            if(result > 0 ){

                result = 0;

                result = reItemMapper.deleteReturnItems(rNo);
            }
        }

        return result;
    }
}
