package com.artisans.beans;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/4/13 0:06
 * @mark: show me the code , change the world
 */


public class ArtisanImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName(ArtisanBean.class.getName());
        MutablePropertyValues values = beanDefinition.getPropertyValues();
        values.addPropertyValue("name", "HaHa");
        //这里注册bean
        registry.registerBeanDefinition("artisanBean", beanDefinition);
    }
}
    