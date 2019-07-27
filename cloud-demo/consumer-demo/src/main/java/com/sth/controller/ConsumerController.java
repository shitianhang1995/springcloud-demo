package com.sth.controller;

import com.sth.client.UserClient;
import com.sth.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: root
 * @Date: 2019/7/26 05:16
 * @Description:
 */
@RestController
@RequestMapping("consumer")
@Slf4j
//@DefaultProperties(defaultFallback = "consumerFallbackMethod")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RibbonLoadBalancerClient client;

    @GetMapping("{id}")
    public User consumer(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }

//    @GetMapping("{id}")
//    public String consumer(@PathVariable("id") Long id) {
//        if(id==2){
//            throw new RuntimeException("请求失败");
//        }
//        String url = "http://user-service/user/" + id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }

//    @GetMapping("{id}")
//    @HystrixCommand(commandProperties = {
//            //熔断设置 睡眠时间20s，请求计数10个，失败阈值60%
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
//    public String consumer(@PathVariable("id") Long id) {
//        if(id==2){
//            throw new RuntimeException("请求失败");
//        }
//        String url = "http://user-service/user/" + id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }

    public String consumerFallbackMethod() {
        return "服务器太累";
    }

//    @GetMapping("{id}")
//    public User consume(@PathVariable("id") Long id) {
//        //根据服务ID获取实例---第一种
////        ServiceInstance instance = client.choose("user-service");
//        //从实例中取出ip和端口---第二种
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        ServiceInstance serviceInstance = instances.get(0);
////        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
////        log.info(serviceInstance.getHost() + ":" + serviceInstance.getPort());
//        //在RestTemplate加@LoadBalanced拦截---第三种
//        String url = "http://user-service/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }
}