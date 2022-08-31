package com.chicken.project.notice.model.service;


import com.chicken.project.notice.model.dao.NoticeMapper;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper){

        this.noticeMapper = noticeMapper;
    }

    public List<NoticeDTO> selectAllList() {

        return noticeMapper.selectAllList();
    }

    public int noticeInsert(NoticeDTO notice) {

        return noticeMapper.noticeInsert(notice);
    }


    public int noticeFileInsert(NoticeFileDTO noticeFile) {

        return noticeMapper.noticeFileInsert(noticeFile);
    }

    public NoticeDTO noticeDetailByNo(int noticeNo) {

        return noticeMapper.noticeDetailByNo(noticeNo);
    }
}
