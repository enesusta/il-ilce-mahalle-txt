package com.enesusta.scripts.district.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Date;


@Configuration
@PropertySource("application.properties")
public class DatabaseConfiguration {

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String pass;

    @Bean
    public DataSource dataSource() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(pass);

        System.out.printf("Connected : %s\n", new Date());

        return dataSource;
    }

}
