package cn.syw.springframework.beans.factory.config;

import cn.syw.springframework.beans.PropertyValues;

public class BeanDefinition {
    private PropertyValues propertyValues;
    private Class beanClass;
    public BeanDefinition(Class bean) {
        this.beanClass = bean;
        this.propertyValues = new PropertyValues();
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
    public Class getBeanClass() {
        return beanClass;
    }


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
