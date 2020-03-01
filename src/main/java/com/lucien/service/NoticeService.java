package com.lucien.service;

import com.github.pagehelper.PageInfo;
import com.lucien.po.Notice;

public interface NoticeService {
    PageInfo<Notice> queryNoticeByPage(int pageNum, int pageSize);

    Notice queryNoticeByNoticeStatus();

    int addNotice(String noticeTitle, String noticeContent);

    int deleteNoticeByNoticeId(int noticeId);

    Notice queryNoticeByNoticeId(int noticeId);

    int updateNoticeByNoticeId(int noticeId, String noticeTitle, String noticeContent);

    int updateNoticeStatus(int noticeId, boolean noticeStatus);
}
