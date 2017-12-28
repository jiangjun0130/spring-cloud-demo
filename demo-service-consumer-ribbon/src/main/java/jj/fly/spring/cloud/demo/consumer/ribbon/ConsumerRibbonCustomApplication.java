package jj.fly.spring.cloud.demo.consumer.ribbon;

import jj.fly.spring.cloud.demo.consumer.config.TestConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangjun
 * @create 2017/11/27
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "eureka-provider", configuration = TestConfiguration.class)
public class ConsumerRibbonCustomApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerRibbonCustomApplication.class).web(true).run(args);
    }
}
