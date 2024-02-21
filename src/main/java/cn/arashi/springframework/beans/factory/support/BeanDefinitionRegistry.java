package cn.arashi.springframework.beans.factory.support;

import cn.arashi.springframework.beans.factory.factory.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
