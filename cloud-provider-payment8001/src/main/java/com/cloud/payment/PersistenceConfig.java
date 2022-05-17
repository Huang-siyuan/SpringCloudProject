//package com.cloud.payment;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * @program: SpringCloudTry
// * @description: Configuration of persistence
// * @author: Siyuan
// * @create: 2022-05-16 18:45
// **/
//
//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//public class PersistenceConfig {
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.type}")
//    private String datasourceType;
//
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource ds = new DruidDataSource();
//        ds.setUrl(dbUrl);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        ds.setDbType(datasourceType);
//        return ds;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        return factoryBean.getObject();
//    }
//}
