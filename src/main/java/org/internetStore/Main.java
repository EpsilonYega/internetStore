package org.internetStore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.internetStore.models.entities.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {


    public static ApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(Main.class, args);
    }
}