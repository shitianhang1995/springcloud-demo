package com.sth.client;

import com.sth.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: root
 * @Date: 2019/7/26 18:43
 * @Description:
 */
@Component
public class UserClientImpl implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("未知用户");
        return user;
    }
}
