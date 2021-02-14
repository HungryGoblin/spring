package ru.geekbrains.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
@ComponentScan("ru.geekbrains.product")
public class AppConfig {

    @Bean
    public DatabaseController databaseController() throws SQLException {
        return new DatabaseController();
    }

    @Bean
    public ProductService productService() {
        return new ProductService(null);
    }

}
