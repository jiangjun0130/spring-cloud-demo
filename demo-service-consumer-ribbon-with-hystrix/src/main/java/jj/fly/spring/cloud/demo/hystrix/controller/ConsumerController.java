package jj.fly.spring.cloud.demo.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jj.fly.spring.cloud.demo.hystrix.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "findByIdCallback")
    public User findById(@PathVariable("id") Long id){
        logger.info("invoke method findById...");
        // VIP
        return restTemplate.getForObject("http://EUREKA-PROVIDER/test/findById/" + id,User.class);
    }

    public User findByIdCallback(Long id){
        User user = new User(-1L,"error","error",-1);
        return user;
    }
}
