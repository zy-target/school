package cn.zyforget.school.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = { "cn.zyforget.school.gateway"})
public class GatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
