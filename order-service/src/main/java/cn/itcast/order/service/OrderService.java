package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.Order;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用Feign发起请求
        User user = userClient.findById(order.getUserId());
        // 3.将用户信息设置到订单中
        order.setUser(user);
        // 4.返回
        return order;
    }
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用RestTemplate发起请求
//        User user = restTemplate.getForObject("http://user-service/user/" + order.getUserId(), User.class);
//        // 3.将用户信息设置到订单中
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
