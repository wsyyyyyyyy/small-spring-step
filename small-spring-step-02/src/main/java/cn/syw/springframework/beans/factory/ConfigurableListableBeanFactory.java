package cn.syw.springframework.beans.factory;

import cn.syw.springframework.beans.BeansException;
import cn.syw.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.syw.springframework.beans.factory.config.BeanDefinition;
import cn.syw.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    void preInstantiateSingletons() throws BeansException;

}