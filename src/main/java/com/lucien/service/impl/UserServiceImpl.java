package com.lucien.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucien.dao.UserMapper;
import com.lucien.model.entity.User;
import com.lucien.model.entity.UserExample;
import com.lucien.service.UserService;
import com.lucien.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/19 20:30
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserByUserName(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria  criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return userMapper.selectByExample(example);
    }

    @Override
    public int addUser(String userName, String userPassword) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(MD5Util.getMD5(userPassword));
        return userMapper.insertSelective(user);
    }

    @Override
    public PageInfo<User> queryUserByPage(int pageNum, int pageSize, String keyword) {
        UserExample example = new UserExample();
        if (!StringUtils.isEmpty(keyword)) {
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserNameLike('%' + keyword + '%');
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectByExample(example);
        return new PageInfo<>(users);
    }

    @Override
    public int updateUserStatusByUserId(int userId, boolean userStatus) {
        User user = new User();
        user.setUserId(userId);
        user.setUserStatus(userStatus);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User queryUserByUserId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
