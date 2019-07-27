package com.sth.client;

import com.sth.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: root
 * @Date: 2019/7/26 18:30
 * @Description:
 */
@FeignClient(value = "user-service",fallback = UserClientImpl.class)
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
