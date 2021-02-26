package ru.hiber.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.hiber.entities.Product;

import java.net.URISyntaxException;

public class CrudApp implements AutoCloseable {

    private static SessionFactory factory;

    @Override
    public void close() throws Exception {
        factory.close();
    }

    public static void createProductExample() {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product(4L, "Airpods", 200);
            session.save(product);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void readProductExample(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void editProductExample(long id, String title, int price) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(title);
            product.setPrice(price);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void deleteExample(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product prod = session.get(Product.class, id);
            session.delete(prod);
            session.getTransaction().commit();
        }
    }
    public static void init() throws URISyntaxException {
        new ru.hiber.PrepareDataApp().forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate_cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
            createProductExample();
            readProductExample(1);
            editProductExample(1, "Mac Air", 1000);
            deleteExample(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
