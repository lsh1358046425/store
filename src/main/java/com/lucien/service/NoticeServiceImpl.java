package com.lucien.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucien.dao.NoticeMapper;
import com.lucien.po.Notice;
import com.lucien.po.NoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/24 18:32
 */

@Transactional
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<Notice> queryNoticeByPage(int pageNum, int pageSize) {
        NoticeExample example = new NoticeExample();
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> notices = noticeMapper.selectByExample(example);
        return new PageInfo<>(notices);
    }

    @Override
    public Notice queryNoticeByNoticeStatus() {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeStatusEqualTo(true);
        List<Notice> notice = noticeMapper.selectByExample(example);
        if (notice.isEmpty()){
            return null;
        }
        return notice.get(0);
    }

    @Override
    public int addNotice(String noticeTitle, String noticeContent) {
        Notice notice = new Notice();
        notice.setNoticeTime(new Date());
        notice.setNoticeTitle(noticeTitle);
        notice.setNoticeContent(noticeContent);
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public int deleteNoticeByNoticeId(int noticeId) {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }

    @Override
    public Notice queryNoticeByNoticeId(int noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Override
    public int updateNoticeByNoticeId(int noticeId, String noticeTitle, String noticeContent) {
        Notice notice = new Notice();
        notice.setNoticeTitle(noticeTitle);
        notice.setNoticeContent(noticeContent);
        notice.setNoticeId(noticeId);
        notice.setNoticeTime(new Date());
        return noticeMapper.updateByPrimaryKey(notice);
    }

    @Override
    public int updateNoticeStatus(int noticeId, boolean noticeStatus) {
        if (noticeStatus){
            //true即为发布，先把noticeId公告状态改为1，再把其他公告状态都改为0
            Notice notice1 = new Notice();
            notice1.setNoticeId(noticeId);
            notice1.setNoticeStatus(true);
            noticeMapper.updateByPrimaryKeySelective(notice1);
            //公告状态都改为0
            NoticeExample example = new NoticeExample();
            NoticeExample.Criteria criteria = example.createCriteria();
            criteria.andNoticeIdNotEqualTo(noticeId);
            Notice notice2 = new Notice();
            notice2.setNoticeStatus(false);
            noticeMapper.updateByExampleSelective(notice2, example);
        }else {
            //false下架公共
            Notice notice3 = new Notice();
            notice3.setNoticeId(noticeId);
            notice3.setNoticeStatus(false);
            noticeMapper.updateByPrimaryKeySelective(notice3);
        }
        return 1;
    }
}
