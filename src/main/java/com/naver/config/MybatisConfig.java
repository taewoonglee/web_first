//package com.naver.config;
//
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MybatisConfig {
//    private final DataSource dataSource;
//    public MybatisConfig(BasicDataSource dataSource)
//    {
//        this.dataSource=dataSource;
//    }
//    public DataSource dataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setD
//    }
//    @Bean
//    public SqlSessionFactoryBean SqlSessionFactoryBean()
//    {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setConfigLocation("classpath:/config/mybatisConfig.xml");
//        factoryBean.setMapperLocations(new FileSystemResource("class:/sqlMap/*.xml"));
//        factoryBean.setDataSource(dataSource);
//        return factoryBean;
//    }
//    public SqlSessionTemplate sqlSessionTemplate(){
//        return new SqlSessionTemplate((SqlSessionFactory) sessionFactoryBean());
//    }
//
//}
