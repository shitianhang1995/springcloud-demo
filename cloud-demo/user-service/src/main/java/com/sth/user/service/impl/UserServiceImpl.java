package com.sth.user.service.impl;

import com.sth.user.mapper.UserMapper;
import com.sth.user.pojo.User;
import com.sth.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: root
 * @Date: 2019/7/26 03:55
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
