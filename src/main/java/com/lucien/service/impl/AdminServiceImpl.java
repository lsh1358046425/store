package com.lucien.service.impl;

import com.lucien.dao.AdminMapper;
import com.lucien.model.entity.Admin;
import com.lucien.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lucien
 * @version 1.0
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
