package jj.fly.spring.cloud.demo.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author jj02 jiangjun
 * @create 2017/11/30
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulRegExpApplication {

    /**
     * 使用routePattern格式地址即可访问。
     * 如：
     * application.name: eureka-provider-v1
     * url：http://10.66.19.61:8040/v1/eureka-provider/test/findById/1
     *
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulRegExpApplication.class).web(true).run(args);
    }
}
