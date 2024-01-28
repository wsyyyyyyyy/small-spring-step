package cn.syw.springframework.beans.factory.support;

import cn.syw.springframework.beans.BeansException;
import cn.syw.springframework.beans.factory.BeanFactory;
import cn.syw.springframework.beans.factory.config.BeanDefinition;
import cn.syw.springframework.beans.factory.config.BeanPostProcessor;
import cn.syw.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException{
        return doGetBean(name,null);
    }
    @Override
    public Object getBean(String name,Object... args) throws BeansException{
        return doGetBean(name,args);
    }
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }
    protected <T> T doGetBean(final String name,final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }
    protected abstract BeanDefinition getDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String name,BeanDefinition beanDefinition,Object[] args);
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
