package jj.fly.spring.cloud.demo.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jj02 jiangjun
 * @create 2017/12/1
 */
@FeignClient(name = "demo-sidecar")
public interface SidecarFeignClient {

    @GetMapping("/health.json")
    String health();

}
