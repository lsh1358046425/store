package com.lucien.service;

import com.lucien.model.entity.Admin;

public interface AdminService {
    Admin queryAdminByAdminName(String adminName);
}
