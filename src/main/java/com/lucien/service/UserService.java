package com.lucien.service;

import com.github.pagehelper.PageInfo;
import com.lucien.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUserByUserName(String userName);

    int addUser(String userName, String userPassword);

    PageInfo<User> queryUserByPage(int pageNum, int pageSize, String keyword);

    int updateUserStatusByUserId(int userId, boolean userStatus);

    User queryUserByUserId(int userId);
}
