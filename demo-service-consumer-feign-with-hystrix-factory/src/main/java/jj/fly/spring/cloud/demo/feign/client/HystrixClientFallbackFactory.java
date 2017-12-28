package jj.fly.spring.cloud.demo.feign.client;

import feign.hystrix.FallbackFactory;
import jj.fly.spring.cloud.demo.feign.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jj02 jiangjun
 * @create 2017/11/29
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private Logger logger = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        logger.error("fallback; reason was:{}",throwable);

        return new UserFeignClientWithFactory(){

            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-3L);
                return user;
            }
        };
    }
}
