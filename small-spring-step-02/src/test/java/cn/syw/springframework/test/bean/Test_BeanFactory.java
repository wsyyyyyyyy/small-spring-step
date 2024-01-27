package cn.syw.springframework.test.bean;

import cn.syw.springframework.beans.factory.BeanFactory;
import cn.syw.springframework.beans.factory.config.BeanDefinition;
import cn.syw.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.syw.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class Test_BeanFactory {
    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService2 = (UserService)beanFactory.getBean("userService");
        userService2.queryUserInfo();
    }
}
