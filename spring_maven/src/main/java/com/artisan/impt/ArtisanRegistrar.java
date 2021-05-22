package com.artisan.impt;

import com.artisan.beans.Artisan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 9:28
 * @mark: show me the code , change the world
 */
public class ArtisanRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Artisan.class);
        builder.setScope(BeanDefinition.SCOPE_SINGLETON);
        builder.addPropertyValue("name", "小工匠Registrar");
        builder.addPropertyValue("age", "18");
        registry.registerBeanDefinition("artisan", builder.getBeanDefinition());
    }
}
    