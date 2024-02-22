package cn.arashi.springframework.beans.factory.support;

import cn.arashi.springframework.core.io.Resource;
import cn.arashi.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(Resource... resources) throws Exception;

    void loadBeanDefinitions(String location) throws Exception;
}
