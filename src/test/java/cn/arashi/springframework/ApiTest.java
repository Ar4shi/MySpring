package cn.arashi.springframework;

import cn.arashi.springframework.bean.UserDao;
import cn.arashi.springframework.bean.UserService;
import cn.arashi.springframework.beans.PropertyValue;
import cn.arashi.springframework.beans.PropertyValues;
import cn.arashi.springframework.beans.factory.factory.BeanDefinition;
import cn.arashi.springframework.beans.factory.factory.BeanReference;
import cn.arashi.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() throws Exception {

        // 1.初始化 BeanFactory
        DefaultSingletonBeanRegistry beanFactory = new DefaultSingletonBeanRegistry();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
