package jj.fly.spring.cloud.demo.feign.client;

import jj.fly.spring.cloud.demo.feign.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jj02 jiangjun
 * @create 2017/11/27
 */
@FeignClient(name = "eureka-provider")
public interface UserFeignClient {

//    @RequestMapping(method = RequestMethod.GET, value = "/stores")
//    List<Store> getStores();

    @GetMapping("/test/findById/{id}")
    //@RequestMapping(value = "/test/findById/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}
