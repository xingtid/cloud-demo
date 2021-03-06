package cn.itcast.order;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.FeignClientConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// 添加包扫描
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = FeignClientConfiguration.class)
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate对象
     */
    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }
}