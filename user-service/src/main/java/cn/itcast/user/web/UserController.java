package cn.itcast.user.web;

import cn.itcast.user.config.Properties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RefreshScope
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//    @Value("${zeal.he}")
//    private String patternData;

    @Autowired
    private Properties properties;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value = "X-Request-Id", required = false) String XRequestId) {
        System.out.println("X-Request-Id:" + XRequestId);
        return userService.queryById(id);
    }

    @GetMapping("config")
    public Properties queryConfig() {
//        return patternData;
        return properties;
    }
}
