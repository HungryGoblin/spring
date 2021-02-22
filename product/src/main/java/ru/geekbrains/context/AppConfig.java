//package ru.geekbrains.context;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import ru.geekbrains.mvc.repo.DatabaseController;
//
//import java.sql.SQLException;
//
//@Configuration
//@ComponentScan("ru.geekbrains.mvc.model")
//public class AppConfig {
//
//    @Bean
//    public DatabaseController databaseController() throws SQLException {
//        return new DatabaseController();
//    }
//
//    @Bean
//    public ProductService productService() {
//        return new ProductService(null);
//    }
//
//}
