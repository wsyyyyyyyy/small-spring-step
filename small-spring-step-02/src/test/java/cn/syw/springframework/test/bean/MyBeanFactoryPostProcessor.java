package cn.syw.springframework.test.bean;


import cn.syw.springframework.beans.BeansException;
import cn.syw.springframework.beans.PropertyValue;
import cn.syw.springframework.beans.PropertyValues;
import cn.syw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.syw.springframework.beans.factory.config.BeanDefinition;
import cn.syw.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
