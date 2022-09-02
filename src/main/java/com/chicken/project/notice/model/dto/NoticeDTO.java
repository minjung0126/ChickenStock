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
    private NoticeFileDTO noticeFile;

    public NoticeDTO() {}

    public NoticeDTO(int noticeNo, String noticeName, String noticeContent, Date noticeRegistDate, Date noticeModifyDate, String empId, NoticeFileDTO noticeFile) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeModifyDate = noticeModifyDate;
        this.empId = empId;
        this.noticeFile = noticeFile;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public void setNoticeRegistDate(Date noticeRegistDate) {
        this.noticeRegistDate = noticeRegistDate;
    }

    public void setNoticeModifyDate(Date noticeModifyDate) {
        this.noticeModifyDate = noticeModifyDate;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setNoticeFile(NoticeFileDTO noticeFile) {
        this.noticeFile = noticeFile;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public Date getNoticeRegistDate() {
        return noticeRegistDate;
    }

    public Date getNoticeModifyDate() {
        return noticeModifyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public NoticeFileDTO getNoticeFile() {
        return noticeFile;
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
                ", noticeFile=" + noticeFile +
                '}';
    }
}


