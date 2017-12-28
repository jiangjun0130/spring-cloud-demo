package jj.fly.spring.cloud.demo.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author jj02 jiangjun
 * @create 2017/11/30
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFallbackApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulFallbackApplication.class).web(true).run(args);
    }
}
