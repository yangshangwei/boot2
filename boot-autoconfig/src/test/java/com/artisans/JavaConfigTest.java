package com.artisans;


import com.alibaba.druid.pool.DruidDataSource;
import com.artisans.beans.AA;
import com.artisans.beans.ArtisanBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext;

    @Before
    public void before() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
    }


    @Test
    public void test02() {
        DruidDataSource bean = (DruidDataSource) annotationConfigApplicationContext.getBean("dataSource");
        System.out.println(bean);

    }

//    @Test
//    public void test03() {
//        AA bean = (AA) annotationConfigApplicationContext.getBean("aa");
//        System.out.println(bean);
//
//    }
//
//
//    /**
//     * @Import(ArtisanImportSelector.class)
//     */
//    @Test
//    public void test05() {
//        AA bean = annotationConfigApplicationContext.getBean(AA.class);
//        bean.setAddress("China");
//        System.out.println(bean.getAddress());
//    }
//
//    /**
//     * @Import(ArtisanImportBeanDefinitionRegistrar.class)
//     */
//    @Test
//    public void test06() {
//        ArtisanBean bean = annotationConfigApplicationContext.getBean(ArtisanBean.class);
//        System.out.println(bean.getName());
//    }


}
