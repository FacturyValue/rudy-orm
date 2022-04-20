package com.springdatajpa.java;

import com.springdatajpa.java.config.FancyDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * use @SpringBootApplication as the same as @Configuration @EnableAutoConfiguration @ComponentScan
 */
@SpringBootApplication()
public class JpaHelloworldApplication {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext ctx = SpringApplication.run(JpaHelloworldApplication.class, args);
        /*String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println("datasource:"+dataSource.getConnection());
        //DataSource hikariDatasource = (DataSource) ctx.getBean("hikariDataSource");
        //System.out.println("hikari:"+hikariDatasource.getConnection());
    }

    /**
     * 获取的连接为:datasource:com.mysql.cj.jdbc.ConnectionImpl@2373ad99
     * @return
     */
   /* @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new FancyDataSource();
    }*/

    /**
     * 获取到的连接为
     *  HikariProxyConnection@5933746 wrapping com.mysql.cj.jdbc.ConnectionImpl@3f50b680
     * @return
     */
   /* @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*/

   @Bean
   @ConfigurationProperties("app.datasource")
   public DataSource dataSource(){
       return DataSourceBuilder.create().build();
   }


}
