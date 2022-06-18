package cn.itcast.feign.clients;

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hystrix-m")
public interface HmClient {
    @GetMapping("/payment/hystrix/timeout/{id}")
    User paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
