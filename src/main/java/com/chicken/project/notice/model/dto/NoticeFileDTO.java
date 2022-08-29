package com.chicken.project.notice.model.dto;

public class NoticeFileDTO {

    private int fileNo; // 파일번호
    private String originName; // 원본이름
    private String fileName; // 바뀐이름
    private int noticeNo; // 공지사항 번호

    public NoticeFileDTO() {}

    public NoticeFileDTO(int fileNo, String originName, String fileName, int noticeNo) {
        this.fileNo = fileNo;
        this.originName = originName;
        this.fileName = fileName;
        this.noticeNo = noticeNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public String getOriginName() {
        return originName;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    @Override
    public String toString() {
        return originName;

    }
}
