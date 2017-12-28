package jj.fly.spring.cloud.demo.consumer.controller;

import jj.fly.spring.cloud.demo.consumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.path}")
    private String path;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id){
        return restTemplate.getForObject(path + id,User.class);
    }
}
