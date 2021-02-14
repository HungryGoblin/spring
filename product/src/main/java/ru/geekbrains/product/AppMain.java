package ru.geekbrains.product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppMain {

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DatabaseController databaseController = context.getBean("databaseController", DatabaseController.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        DatabaseProductContainer databaseProductContainer =
                context.getBean("databaseProductContainer", DatabaseProductContainer.class);

        databaseController.deleteProduct();
        for (int i = 0; i < 10; i++) {
            databaseController.addProduct(new Product(i, String.valueOf(i), (i + 1) * 100.30f));
        }

        productService.setProductContainer(databaseProductContainer);
        System.out.println(productService.getAverageCost());
        
    }

}
