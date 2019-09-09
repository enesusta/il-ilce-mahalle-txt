package com.enesusta.scripts.district.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

    public static ClassPathXmlApplicationContext getApplicationContext() {
        final ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
        return context;
    }

}
