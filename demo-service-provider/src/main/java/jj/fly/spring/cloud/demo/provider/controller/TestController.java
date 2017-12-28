package jj.fly.spring.cloud.demo.provider.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import jj.fly.spring.cloud.demo.provider.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author jj02 jiangjun
 * @create 2017/11/27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/home")
    public String home(){
        return "Hello world!";
    }

    @RequestMapping("/saveUser")
    public String saveUser(){
        return "ok!";
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        logger.info("invoke method findById...");
        return new User(1L,"jj","jiangjun",27);
    }

    @GetMapping("/getServices")
    public List<String> getServices(){
        List<String> services = discoveryClient.getServices();
        return services;
    }

    @GetMapping("/getInstances")
    public List<ServiceInstance> getInstances(String serviceId){
        return discoveryClient.getInstances(serviceId);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("EUREKA-PROVIDER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance serviceInfo() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return instance;
    }

}
