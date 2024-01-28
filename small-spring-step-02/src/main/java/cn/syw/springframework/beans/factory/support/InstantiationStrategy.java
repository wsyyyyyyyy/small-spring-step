package cn.syw.springframework.beans.factory.support;

import cn.syw.springframework.beans.BeansException;
import cn.syw.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;}
