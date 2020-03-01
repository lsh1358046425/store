package com.lucien.po;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private String noticeTitle;

    private String noticeContent;

    private Date noticeTime;

    private Boolean noticeStatus;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Boolean getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Boolean noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}