package com.chicken.project.notice.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class NoticeDTO {
    
    private int noticeNo; // 공지사항 번호
    private String noticeName; // 공지사항 제목
    private String noticeContent; // 공지사항 내용
    private Date noticeRegistDate; // 공지사항 등록일
    private Date noticeModifyDate; // 공지사항 수정일
    private String empName; // 등록자 이름
    private int noticeCount; // 조회수
    private NoticeFileDTO noticeFile; // 공지사항 파일
    
}


