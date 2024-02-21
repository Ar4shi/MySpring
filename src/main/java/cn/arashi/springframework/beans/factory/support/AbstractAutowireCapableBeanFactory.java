package cn.arashi.springframework.beans.factory.support;

import cn.arashi.springframework.beans.factory.factory.BeanDefinition;

/**
 * 实例化Bean抽象类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Object bean = null;
        try {
            // 有构造函数入参的对象怎么处理?
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Exception("Instantiation of bean failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
