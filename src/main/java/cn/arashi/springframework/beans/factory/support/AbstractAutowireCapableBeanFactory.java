package cn.arashi.springframework.beans.factory.support;

import cn.arashi.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化Bean抽象类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws Exception {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Exception("Instantiation of bean failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws Exception {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
