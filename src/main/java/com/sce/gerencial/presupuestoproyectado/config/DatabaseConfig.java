/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sce.gerencial.presupuestoproyectado.config;


import com.sce.gerencial.presupuestoproyectado.util.IniUtil;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author CPizarro
 */
@Configuration
public class DatabaseConfig {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(IniUtil.readIni("Conexion", "driver"));
        dataSource.setUrl(IniUtil.readIni("Conexion", "url").replace("{[HOST]}", IniUtil.readIni("Conexion", "server")).replace("{[PORT]}", IniUtil.readIni("Conexion", "puerto")).replace("{[DATA]}", IniUtil.readIni("Conexion", "dbname")));
        dataSource.setUsername(IniUtil.readIni("Conexion", "user"));
        dataSource.setPassword(IniUtil.readIni("Conexion", "pass"));
        return dataSource;
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

}
