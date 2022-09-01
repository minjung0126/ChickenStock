package com.chicken.project.calendar.model.dto;

import java.util.Date;

public class CalendarDTO {

    private int no;
    private String name;
    private java.util.Date start;
    private java.util.Date end;
    private String content;
    private String id;
    private String groupNO;

    public CalendarDTO() {
    }

    public CalendarDTO(int no, String name, Date start, Date end, String content, String id, String groupNO) {
        this.no = no;
        this.name = name;
        this.start = start;
        this.end = end;
        this.content = content;
        this.id = id;
        this.groupNO = groupNO;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupNO() {
        return groupNO;
    }

    public void setGroupNO(String groupNO) {
        this.groupNO = groupNO;
    }

    @Override
    public String toString() {
        return "CalendarDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", groupNO='" + groupNO + '\'' +
                '}';
    }
}
