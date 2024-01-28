package cn.syw.springframework.beans.factory;


import cn.syw.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    Object getBean(String beanName,Object... args) throws BeansException;
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
