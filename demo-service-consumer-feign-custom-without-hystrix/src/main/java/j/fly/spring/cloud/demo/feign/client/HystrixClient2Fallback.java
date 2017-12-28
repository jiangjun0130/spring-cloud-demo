package j.fly.spring.cloud.demo.feign.client;

import org.springframework.stereotype.Component;

@Component
class HystrixClient2Fallback implements FeignClient2 {

    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "fuck";
    }
}