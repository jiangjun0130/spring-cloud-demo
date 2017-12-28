package jj.fly.spring.cloud.demo.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author jj02 jiangjun
 * @create 2017/11/27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerFeignWithHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignWithHystrixApplication.class,args);
    }
}
