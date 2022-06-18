package cn.itcast.feign.clients;

import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j;

@Log4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {

                return new User();
            }
        };
    }
}
