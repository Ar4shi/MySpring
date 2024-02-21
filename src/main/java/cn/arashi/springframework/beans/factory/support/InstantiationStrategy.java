package cn.arashi.springframework.beans.factory.support;

import cn.arashi.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws Exception;
}
