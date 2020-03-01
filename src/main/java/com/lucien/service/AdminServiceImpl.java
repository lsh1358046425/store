package com.lucien.service;

import com.lucien.dao.AdminMapper;
import com.lucien.po.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/11 13:44
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryAdminByAdminName(String adminName) {
        return adminMapper.selectByPrimaryKey(adminName);
    }
}
