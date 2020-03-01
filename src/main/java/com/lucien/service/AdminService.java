package com.lucien.service;

import com.lucien.po.Admin;

public interface AdminService {
    Admin queryAdminByAdminName(String adminName);
}
