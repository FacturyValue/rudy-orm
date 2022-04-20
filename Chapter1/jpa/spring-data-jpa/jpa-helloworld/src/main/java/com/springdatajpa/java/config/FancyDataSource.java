package com.springdatajpa.java.config;

import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public  class FancyDataSource implements DataSource {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;
    Properties properties = null;
    Connection connect = null;

    {
        properties = new Properties();
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
            //通过反射获取Driver
            Driver driver = (Driver) clazz.newInstance();
            //获取数据库连接
            properties.setProperty("user",username);
            properties.setProperty("password",password);
            connect = driver.connect(url, properties);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            //关闭连接 如果此方法在test类中需关闭连接
            //if (connect != null) {
            //    connect.close();
            //}
        }
        return connect;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {

        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
