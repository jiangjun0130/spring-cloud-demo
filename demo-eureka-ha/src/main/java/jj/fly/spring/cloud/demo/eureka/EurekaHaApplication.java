package jj.fly.spring.cloud.demo.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jiangjun
 * @create 2017/11/24
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaHaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(EurekaApplication.class,args);
        new SpringApplicationBuilder(EurekaHaApplication.class).web(true).run(args);
    }

}
