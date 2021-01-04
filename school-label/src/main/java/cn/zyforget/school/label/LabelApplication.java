package cn.zyforget.school.label;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(value = {"cn.zyforget.school.label", "school.config"})
@EnableSwagger2
@EnableDiscoveryClient
public class LabelApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabelApplication.class, args);
    }
}
