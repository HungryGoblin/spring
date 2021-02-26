package ru.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareDataApp {

    public static void forcePrepareData() {
        SessionFactory factory = new Configuration()
                .configure("configs/hibernate_cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            Path SQLScript = Paths.get(ClassLoader.getSystemResource("sql/create_product.sql").toURI());
            String sql = Files.lines(SQLScript).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        forcePrepareData();
    }
}
