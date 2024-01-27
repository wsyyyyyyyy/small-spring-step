package cn.syw.springframework.test.bean;

import cn.syw.springframework.BeanDefinition;
import cn.syw.springframework.BeanFactory;
import org.junit.Test;

public class Test_BeanFactory {
    @Test
    public void test() {
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
