package j.fly.spring.cloud.demo.feign.client;

import j.fly.spring.cloud.demo.feign.domain.User;
import org.springframework.stereotype.Component;

@Component
class HystrixClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-2L);
        return user;
    }
}