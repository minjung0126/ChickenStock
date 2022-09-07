package com.chicken.project.notice.model.dto;

import java.sql.Date;
import java.util.List;

public class NoticeDTO {
    
    private int noticeNo; // 공지사항 번호
    private String noticeName; // 공지사항 제목
    private String noticeContent; // 공지사항 내용
    private Date noticeRegistDate; // 공지사항 등록일
    private Date noticeModifyDate; // 공지사항 수정일
    private String empId; // 등록자 아이디
    private int noticeCount; // 조회수
    private NoticeFileDTO noticeFile; // 공지사항 파일

    public NoticeDTO() {}

    public NoticeDTO(int noticeNo, String noticeName, String noticeContent, Date noticeRegistDate, Date noticeModifyDate, String empId, int noticeCount, NoticeFileDTO noticeFile) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeModifyDate = noticeModifyDate;
        this.empId = empId;
        this.noticeCount = noticeCount;
        this.noticeFile = noticeFile;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeRegistDate() {
        return noticeRegistDate;
    }

    public void setNoticeRegistDate(Date noticeRegistDate) {
        this.noticeRegistDate = noticeRegistDate;
    }

    public Date getNoticeModifyDate() {
        return noticeModifyDate;
    }

    public void setNoticeModifyDate(Date noticeModifyDate) {
        this.noticeModifyDate = noticeModifyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public NoticeFileDTO getNoticeFile() {
        return noticeFile;
    }

    public void setNoticeFile(NoticeFileDTO noticeFile) {
        this.noticeFile = noticeFile;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeNo=" + noticeNo +
                ", noticeName='" + noticeName + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeRegistDate=" + noticeRegistDate +
                ", noticeModifyDate=" + noticeModifyDate +
                ", empId='" + empId + '\'' +
                ", noticeCount=" + noticeCount +
                ", noticeFile=" + noticeFile +
                '}';
    }
}


