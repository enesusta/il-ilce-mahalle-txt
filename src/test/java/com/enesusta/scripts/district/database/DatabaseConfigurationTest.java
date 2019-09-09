package com.enesusta.scripts.district.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
class DatabaseConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        assertDoesNotThrow(() -> dataSource.getConnection());
    }

}
