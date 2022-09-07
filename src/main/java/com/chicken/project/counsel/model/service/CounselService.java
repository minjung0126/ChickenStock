package com.chicken.project.counsel.model.service;

import com.chicken.project.counsel.model.dao.CounselMapper;
import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("counselService")
public class CounselService {

    private final CounselMapper counselMapper;

    @Autowired
    public CounselService(CounselMapper counselMapper){

        this.counselMapper = counselMapper;
    }
    @Transactional
    public void insertCounsel(CounselDTO counsel) {

        int result = counselMapper.insertCounsel(counsel);

    }

    public List<CounselDTO> selectCounsel() {

        return counselMapper.selectCounsel();
    }

    public CounselDTO selectCounselByNo(int counselNo) {

        return counselMapper.selectCounselByNo(counselNo);
    }

    public void insertCounselApply(String answerContent, int counselNo) {

        int result = counselMapper.insertCounselApply(answerContent, counselNo);

        if(result > 0){

            counselMapper.updateCounsel(counselNo);
        }
    }

    public CounselApplyDTO selectCounselApplyByNo(int counselNo) {

        return counselMapper.selectCounselApplyByNo(counselNo);
    }

    public List<CounselDTO> selectCounselByStoreId(String storeId) {

        return counselMapper.selectCounselByStoreId(storeId);
    }
}
