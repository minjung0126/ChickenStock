package com.chicken.project.notice.model.service;


import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.notice.NoticeDeleteException;
import com.chicken.project.exception.notice.NoticeInsertException;
import com.chicken.project.exception.notice.NoticeUpdateException;
import com.chicken.project.notice.model.dao.NoticeMapper;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper){

        this.noticeMapper = noticeMapper;
    }

    public int noticeInsert(NoticeDTO notice) throws NoticeInsertException {

        int result = noticeMapper.noticeInsert(notice);

        if(!(result > 0)) {

            throw new NoticeInsertException("공지사항 등록 실패!");
        }

        return result;
    }

    public int noticeFileInsert(NoticeFileDTO noticeFile) {

        return noticeMapper.noticeFileInsert(noticeFile);
    }

    public NoticeDTO noticeDetailByNo(int noticeNo) {

        return noticeMapper.noticeDetailByNo(noticeNo);
    }

    public int deleteNotice(int noticeNo) throws NoticeDeleteException {

        int result = noticeMapper.deleteNotice(noticeNo);

        if(!(result > 0)){

            throw new NoticeDeleteException("공지사항 삭제 실패!");
        } else {

            noticeMapper.deleteNoticeFile(noticeNo);
        }

        return result;
    }


    public int updateNotice(NoticeDTO notice) throws NoticeUpdateException {

        int result = noticeMapper.updateNotice(notice);

        if(!(result > 0)){

            throw new NoticeUpdateException("공지사항 수정 실패!");
        }

        return result;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = noticeMapper.selectTotalCount(searchMap);

        return result;
    }

    public List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria) {

        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(selectCriteria);

        return noticeList;
    }

    public NoticeFileDTO selectFileByName(int noticeNo) {

        return noticeMapper.selectFileByName(noticeNo);
    }

    public int deleteNoticeFile(int noticeNo) {

        return noticeMapper.deleteNoticeFile(noticeNo);
    }

    public int updateNoticeFile(NoticeFileDTO noticeFile) {

        return noticeMapper.updateNoticeFile(noticeFile);
    }
}
