package com.group9.seckill.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration //配置注解，表示这是一个配置类
public class DuridConfig {
    //按application.yml中前缀为“spring.datasource”属性
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean //注解Bean，加入容器以使用
    public DataSource druid() {
        return new DruidDataSource();
    }

    @Bean //注解Bean，加入容器以使用
    public ServletRegistrationBean StatViewServlet() {
//          声明ServletRegistrationBean并配置路由
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initparams = new HashMap<>();
//            设置登陆用户及密码，放行路由
        initparams.put("loginUsername", "admin");
        initparams.put("loginPassword", "123456");
        initparams.put("allow", "");
//            initparams.put("deny","localhost");
        bean.setInitParameters(initparams);
        return bean;
    }

    @Bean
//    配置过滤器
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initparams = new HashMap<>();
        initparams.put("exclusions", "*.js,*.css");
        bean.setInitParameters(initparams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
