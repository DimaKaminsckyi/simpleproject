package util;

import entity.Department;
import entity.Lectors;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionUtil {
    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop= new Properties();

            prop.setProperty("hibernate.connection.url",  "jdbc:mysql://localhost:3306/task");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "123123qwe");
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            prop.setProperty("hibernate.hbm2ddl.auto", "create");

            Configuration config = new Configuration();

            config.setProperties(prop);

            config.addAnnotatedClass(Department.class);
            config.addAnnotatedClass(Lectors.class);

            concreteSessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }
}
