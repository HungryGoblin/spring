//package ru.geekbrains.context;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import ru.geekbrains.mvc.model.Product;
//import ru.geekbrains.mvc.repo.DatabaseController;
//import ru.geekbrains.mvc.repo.DatabaseProductContainer;
//import ru.geekbrains.mvc.service.ProductService;
//
//
//import java.sql.SQLException;
//
//public class AppMain {
//
//    public static void main(String[] args) throws SQLException {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        DatabaseController databaseController = context.getBean("databaseController", DatabaseController.class);
//        ProductService productService = context.getBean("productService", ProductService.class);
//        DatabaseProductContainer databaseProductContainer =
//                context.getBean("databaseProductContainer", DatabaseProductContainer.class);
//
//        databaseController.deleteProduct();
//        for (int i = 0; i < 10; i++) {
//            databaseController.addProduct(new Product(i, String.valueOf(i), (i + 1) * 100.30f));
//        }
//
//        productService.setProductContainer(databaseProductContainer);
//        System.out.println(productService.getAverageCost());
//        System.out.println(productService.getSize());
//
//    }
//
//}
