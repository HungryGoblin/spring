package ru.geekbrains.product;

import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseProductContainer implements ProductContainer {

    DatabaseController databaseController = new DatabaseController();

    public DatabaseProductContainer() throws SQLException {

    }

    public List<Product> getProducts() {
        ArrayList<Product> products = null;
        try {
            products = databaseController.getAllProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
