package cn.syw.springframework.beans.factory.support;

import cn.syw.springframework.beans.factory.config.BeanDefinition;
import cn.syw.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String,Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    protected void addSingleton(String beanName,Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }

}
