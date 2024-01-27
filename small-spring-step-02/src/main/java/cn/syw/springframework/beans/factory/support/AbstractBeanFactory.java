package cn.syw.springframework.beans.factory.support;

import cn.syw.springframework.beans.BeansException;
import cn.syw.springframework.beans.factory.BeanFactory;
import cn.syw.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    Map<String, BeanDefinition> beanDefinitionHashMap = new ConcurrentHashMap<>();
    @Override
    public Object getBean(String name) throws BeansException{
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getDefinition(name);
        return createBean(name,beanDefinition);
    }
    protected abstract BeanDefinition getDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String name,BeanDefinition beanDefinition);
}
