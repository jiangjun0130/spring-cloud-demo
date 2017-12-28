package jj.fly.spring.cloud.demo.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author jj02 jiangjun
 * @create 2017/12/1
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFilterApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulFilterApplication.class).web(true).run(args);
    }
}
