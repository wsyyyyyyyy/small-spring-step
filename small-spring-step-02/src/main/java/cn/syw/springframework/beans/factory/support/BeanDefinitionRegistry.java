package cn.syw.springframework.beans.factory.support;

import cn.syw.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
