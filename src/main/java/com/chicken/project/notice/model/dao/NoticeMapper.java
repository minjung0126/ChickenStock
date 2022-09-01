package com.chicken.project.notice.model.dao;

import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectAllList();

    int noticeInsert(NoticeDTO notice);

    int noticeFileInsert(NoticeFileDTO noticeFile);

    NoticeDTO noticeDetailByNo(int noticeNo);

    int deleteNotice(int noticeNo);

    int deleteNoticeFile(int noticeNo);
}
