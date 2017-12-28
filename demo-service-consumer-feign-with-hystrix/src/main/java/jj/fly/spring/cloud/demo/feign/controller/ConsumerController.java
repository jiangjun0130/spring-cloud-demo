package jj.fly.spring.cloud.demo.feign.controller;

import jj.fly.spring.cloud.demo.feign.client.UserFeignClient;
import jj.fly.spring.cloud.demo.feign.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeignClient.findById(id);
    }
}
