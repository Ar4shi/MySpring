package cn.arashi.springframework.beans.factory.support;

import cn.arashi.springframework.beans.factory.BeanFactory;
import cn.arashi.springframework.beans.factory.config.DefaultSingletonBeanRegistry;
import cn.arashi.springframework.beans.factory.factory.BeanDefinition;

/**
 * Bean工厂模板方法
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;
}
