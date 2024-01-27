package cn.syw.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private Map<String,BeanDefinition> beanDefinitionHashMap = new ConcurrentHashMap<>();
    public Object getBean(String name) {
        return beanDefinitionHashMap.get(name).getBean();
    }
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(name,beanDefinition);
    }
}
