package jj.fly.spring.cloud.demo.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author jj02 jiangjun
 * @create 2017/11/28
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@RibbonClient(name = "eureka-provider")
public class RibbonWithHystrixPropagationApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonWithHystrixPropagationApplication.class).web(true).run(args);
    }
}
