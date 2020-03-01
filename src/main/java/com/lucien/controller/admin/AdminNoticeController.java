package com.lucien.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucien.po.JsonData;
import com.lucien.po.LayUITableData;
import com.lucien.po.Notice;
import com.lucien.service.NoticeService;
import com.lucien.util.TimeUtil;
import com.lucien.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/24 18:27
 */

@Controller
@RequestMapping("admin")
public class AdminNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("noticeList")
    public String toNoticeList(){
        return "admin/notice-list";
    }

    @RequestMapping("toNoticeAdd")
    public String toNoticeAdd(){
        return "admin/notice-add";
    }

    @RequestMapping("toNoticeEdit")
    public String toNoticeEdit(@RequestParam int noticeId, Map<String, Object> map){
        Notice notice = noticeService.queryNoticeByNoticeId(noticeId);
        map.put("notice", notice);
        return "admin/notice-edit";
    }

    @ResponseBody
    @RequestMapping("noticeAdd")
    public JsonData noticeAdd(@RequestParam String noticeTitle, @RequestParam String noticeContent){
        JsonData jsonData = new JsonData();
        int count = noticeService.addNotice(noticeTitle, noticeContent);
        if (count == 1) {
            jsonData.setStatus(count);
            jsonData.setMsg("添加成功");
        }else {
            jsonData.setStatus(0);
            jsonData.setMsg("添加失败");
        }
        return jsonData;
    }

    @ResponseBody
    @RequestMapping("noticeStatusUpdate")
    public JsonData noticeStatusUpdate(@RequestParam int noticeId, @RequestParam boolean noticeStatus){
        JsonData jsonData = new JsonData();
        int count = noticeService.updateNoticeStatus(noticeId, noticeStatus);
        if (count == 1) {
            jsonData.setStatus(count);
            jsonData.setMsg("更新成功");
        }else {
            jsonData.setStatus(0);
            jsonData.setMsg("更新失败");
        }
        return jsonData;
    }

    @ResponseBody
    @RequestMapping("noticeUpdate")
    public JsonData noticeUpdate(@RequestParam String noticeTitle, @RequestParam String noticeContent,
                                 @RequestParam int noticeId){
        JsonData jsonData = new JsonData();
        int count = noticeService.updateNoticeByNoticeId(noticeId, noticeTitle, noticeContent);
        if (count == 1) {
            jsonData.setStatus(count);
            jsonData.setMsg("更新成功");
        }else {
            jsonData.setStatus(0);
            jsonData.setMsg("更新失败");
        }
        return jsonData;
    }

    @ResponseBody
    @RequestMapping("getNoticeByPage")
    public LayUITableData getNoticeByPage(@RequestParam(required = false, defaultValue = "1") int page,
                                          @RequestParam(required = false, defaultValue = "10") int limit){
        LayUITableData layUITableData = new LayUITableData();
        PageInfo<Notice> pageInfo = noticeService.queryNoticeByPage(page, limit);
        long count = pageInfo.getTotal();
        List<Notice> notices = pageInfo.getList();
        List<NoticeVO> noticeVOS = new ArrayList<>();
        for(Notice notice : notices){
            NoticeVO noticeVO = new NoticeVO();
            noticeVO.setNoticeId(notice.getNoticeId());
            noticeVO.setNoticeTitle(notice.getNoticeTitle());
            noticeVO.setNoticeContent(notice.getNoticeContent());
            noticeVO.setNoticeStatus(notice.getNoticeStatus());
            noticeVO.setNoticeTime(TimeUtil.getCurrentTimeByDate(notice.getNoticeTime()));
            noticeVOS.add(noticeVO);
        }
        layUITableData.setCode(0);
        layUITableData.setCount(count);
        layUITableData.setData(noticeVOS);
        layUITableData.setMsg("ok");
        return layUITableData;
    }

    @ResponseBody
    @RequestMapping("deleteNotice")
    public JsonData deleteNotice(@RequestParam int noticeId){
        int count = noticeService.deleteNoticeByNoticeId(noticeId);
        JsonData jsonData = new JsonData();
        if (count == 1) {
            jsonData.setStatus(count);
            jsonData.setMsg("删除成功");
        }else {
            jsonData.setStatus(0);
            jsonData.setMsg("删除失败");
        }
        return jsonData;
    }
}
