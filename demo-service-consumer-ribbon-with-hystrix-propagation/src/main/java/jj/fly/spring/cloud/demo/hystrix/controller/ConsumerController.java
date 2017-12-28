package jj.fly.spring.cloud.demo.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jj.fly.spring.cloud.demo.hystrix.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 接口的执行和Hystrix在同一个线程中执行，否则在另一个线程中执行
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "findByIdCallback",
            commandProperties = {@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
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
