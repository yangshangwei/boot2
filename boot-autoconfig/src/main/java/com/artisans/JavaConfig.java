package com.artisans;

import com.alibaba.druid.pool.DruidDataSource;
import com.artisans.beans.AA;
import com.artisans.beans.ArtisanDeferredImportSelector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @author 小工匠
 * @version 1.0
 * @date 2022/4/12 23:40
 * @mark: show me the code , change the world
 */


// 用户标记一个spring配置类,之前是根据xml启动spring上下文
// 相当于 xml文件  <beans></beans>
@Configuration


//== <context:component-scan base-package="com.artisans" >
@ComponentScan(basePackages = "com.artisans")

// 使用@PropertySource 引入外部属性资源文件
@PropertySource("classpath:db.properties")

/* @Import
  1 导入其他的配置类@Import(AnotherConfig.class)
  2.导入类注册为Bean @Import(ArtisanComponent.class)
  3.导入ImportSelector实现类，可以注册多个bean   @Import(ArtisanImportSelector.class)
  4.导入ImportBeanDefinitionRegistrar实现类，可以注册多个BeanDefinition
*/
@Import(ArtisanDeferredImportSelector.class)


public class JavaConfig {


    /*
<bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
        <property name="username" value="${mysql.username}"></property>
        <property name="password" value="${mysql.password}"></property>
        <property name="url"  value="${mysql.url}"></property>
        <property name="driverClassName" value="${mysql.driverClassName}"></property>
    </bean>
*/
    @Value("${mysql.username}")
    private String name;
    @Value("${mysql.password}}")
    private String password;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driverClassName}")
    private String driverClassName;


    /**
     * 可以将一个类的实例(可以干预Bean实例化过程),注册为一个Bean
     * 会自动将返回值作为Bean的类型    将方法名作为bean的名字
     *
     * @Bean(name = "dd") 设置bean的名字及别名（替换）
     * <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
     *
     *
     *
     * @Bean(initMethod = "",destroyMethod = "") = <bean class="xx" id="xx" init-method="initByConfig" destroy-method="destroyByConfig"></bean>
     * <p>
     * 怎么去自动依赖外部Bean:直接在方法里面写上需要依赖的参数即可,不需要写@Autowired
     * 怎么去自动依赖内部Bean：直接调用方法即可
     */
    @Bean(name = {"dataSource", "dd"})
    //@Scope("prototype")  //作用域
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(name);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);

        System.out.println(aa());


        return dataSource;
    }


    @Bean
    public AA aa() {
        System.out.println("AAAAAAAAAAAAAAAAAA");

        return new AA();
    }

}
    