package cn.syw.springframework.test.bean;

import cn.syw.springframework.beans.PropertyValue;
import cn.syw.springframework.beans.PropertyValues;
import cn.syw.springframework.beans.factory.BeanFactory;
import cn.syw.springframework.beans.factory.config.BeanDefinition;
import cn.syw.springframework.beans.factory.config.BeanReference;
import cn.syw.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.syw.springframework.beans.factory.support.ClassPathXmlApplicationContext;
import cn.syw.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.syw.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
    @Test
    public void test_constructor() throws Exception {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "WSY");
        userService.queryUserInfo();
    }
    @Test
    public void test_arr() throws Exception {
//        UserService userService = new UserService("888");
//        System.out.println((Object)userService instanceof BeanDefinition);
    }


    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        // 3. 获取Bean对象调用方法
//        UserService userService = beanFactory.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }
    /**
     * applicationContext
     */
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
