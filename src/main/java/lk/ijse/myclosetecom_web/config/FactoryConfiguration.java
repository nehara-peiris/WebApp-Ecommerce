package lk.ijse.myclosetecom_web.config;

import lk.ijse.myclosetecom_web.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {

        // Set Hibernate properties programmatically
        Properties hibernateProperties = new Properties();
        try {
            hibernateProperties.load(FactoryConfiguration.class.getClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Configure Hibernate with properties and add annotated classes
        Configuration configuration = new Configuration()
                .addProperties(hibernateProperties)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Refund.class)
                .addAnnotatedClass(User.class);

        // Build the session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
