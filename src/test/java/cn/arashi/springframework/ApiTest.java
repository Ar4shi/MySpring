package cn.arashi.springframework;

import cn.arashi.springframework.bean.UserService;
import cn.arashi.springframework.beans.factory.factory.BeanDefinition;
import cn.arashi.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() throws Exception {

        DefaultSingletonBeanRegistry beanFactory = new DefaultSingletonBeanRegistry();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
