package com.sth.user.controller;

import com.sth.user.pojo.User;
import com.sth.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: root
 * @Date: 2019/7/26 03:58
 * @Description:
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public User queryById(@PathVariable("id") Long id) {
        User user = null;
        try {
//            Thread.sleep(2000L);
            user = userService.queryById(id);
            log.info("user=" + user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
