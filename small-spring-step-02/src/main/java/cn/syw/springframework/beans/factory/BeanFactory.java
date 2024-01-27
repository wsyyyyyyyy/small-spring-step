package cn.syw.springframework.beans.factory;


import cn.syw.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
}
