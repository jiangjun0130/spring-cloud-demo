package jj.fly.spring.cloud.demo.consumer.ribbon.controller;

import jj.fly.spring.cloud.demo.consumer.ribbon.domain.User;
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
    public User findById(@PathVariable("id") Long id){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("EUREKA-PROVIDER");
        logger.info("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());// 打印当前调用服务的信息
        logger.info("invoke method findById...");
        // VIP
        return restTemplate.getForObject("http://EUREKA-PROVIDER/test/findById/" + id,User.class);
    }
}
