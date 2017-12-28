package jj.fly.spring.cloud.demo.feign.client;

import feign.Param;
import feign.RequestLine;
import jj.fly.spring.cloud.demo.config.MyFeignConfiguration;
import jj.fly.spring.cloud.demo.feign.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author jj02 jiangjun
 * @create 2017/11/27
 */
@FeignClient(name = "eureka-provider",configuration = MyFeignConfiguration.class)
public interface UserFeignClient {

//    @RequestMapping(method = RequestMethod.GET, value = "/stores")
//    List<Store> getStores();

    //@GetMapping("/test/findById/{id}")
    //@RequestMapping(value = "/test/findById/{id}",method = RequestMethod.GET)
    @RequestLine("GET /test/findById/{id}")
    User findById(@Param("id") Long id);

}
