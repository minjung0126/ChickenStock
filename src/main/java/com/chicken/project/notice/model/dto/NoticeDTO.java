package com.chicken.project.notice.model.dto;

import java.sql.Date;

public class NoticeDTO {
    
    private int noticeNo; // 공지사항 번호
    private String noticeName; // 공지사항 제목
    private String noticeContent; // 공지사항 내용
    private Date noticeRegistDate; // 공지사항 등록일
    private Date noticeModifyDate; // 공지사항 수정일
    private String empId; // 등록자 아이디
    private NoticeFileDTO originName;

    public NoticeDTO() {}

    public NoticeDTO(int noticeNo, String noticeName, String noticeContent, Date noticeRegistDate, Date noticeModifyDate, String empId, NoticeFileDTO originName) {
        this.noticeNo = noticeNo;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
        this.noticeModifyDate = noticeModifyDate;
        this.empId = empId;
        this.originName = originName;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
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

    public NoticeFileDTO getOriginName() {
        return originName;
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
                ", originName=" + originName +
                '}';
    }
}


