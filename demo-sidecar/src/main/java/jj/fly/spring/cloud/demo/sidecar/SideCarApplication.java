package jj.fly.spring.cloud.demo.sidecar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @author jj02 jiangjun
 * @create 2017/11/30
 */
@SpringBootApplication
@EnableSidecar
public class SideCarApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SideCarApplication.class).web(true).run(args);
    }
}
