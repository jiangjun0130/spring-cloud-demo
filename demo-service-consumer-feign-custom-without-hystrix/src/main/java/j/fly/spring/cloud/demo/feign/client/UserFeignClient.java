package j.fly.spring.cloud.demo.feign.client;

import feign.Param;
import feign.RequestLine;
import j.fly.spring.cloud.demo.config.MyFeignConfiguration;
import j.fly.spring.cloud.demo.feign.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jj02 jiangjun
 * @create 2017/11/27
 */
@FeignClient(name = "eureka-provider",fallback = HystrixClientFallback.class,configuration = MyFeignConfiguration.class)
public interface UserFeignClient {

    //@GetMapping("/test/findById/{id}")
    //@RequestMapping(value = "/test/findById/{id}",method = RequestMethod.GET)
    @RequestLine("GET /test/findById/{id}")
    User findById(@Param("id") Long id);

}
