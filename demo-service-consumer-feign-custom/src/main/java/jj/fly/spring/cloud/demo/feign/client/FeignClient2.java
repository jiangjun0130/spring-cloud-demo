package jj.fly.spring.cloud.demo.feign.client;

import jj.fly.spring.cloud.demo.config.MyFeignConfiguration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jj02 jiangjun
 * @create 2017/11/28
 */
@FeignClient(name="xxx",url = "http://localhost:8761/",configuration = MyFeignConfiguration2.class)
public interface FeignClient2 {

    @GetMapping("/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
