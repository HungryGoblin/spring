package ru.geekbrains.product;

import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

@Component
@Primary
public class DatabaseController {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Aviks131";

    private Connection connection;
    private Statement statement;

    private Statement getStatement() throws SQLException {
        if (statement == null) statement = connection.createStatement();
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public DatabaseController() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public ArrayList<Product> getAllProducts() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
        while (resultSet.next()) {
            products.add(new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getFloat("cost")));
        }
        return products;
    }

    public Product getProduct(int id) throws SQLException {
        Product product = null;
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery(String.format(
                "SELECT * FROM product WHERE product.id = %d LIMIT 1", id));
        if (resultSet.next()) {
            product = new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getFloat("cost"));
        }
        return product;
    }

    public boolean addProduct(@NonNull Product product) throws SQLException {
        Statement statement = getStatement();
        return statement.execute(String.format(Locale.US,
                "INSERT INTO product (title, cost) VALUES('%s', %.2f)",
                product.getTitle(), product.getCost()));
    }

    public boolean updateProduct(@NonNull Product product) throws SQLException {
        Statement statement = getStatement();
        return statement.execute(String.format(Locale.US,
                "UPDATE product SET title = '%s', cost = %.2f) WHERE id = %d",
                product.getTitle(), product.getCost(), product.getId()));
    }

    public boolean deleteProduct(int productId) throws SQLException {
        Statement statement = getStatement();
        return statement.execute(String.format("DELETE FROM product WHERE id = %d", productId));
    }

    public boolean deleteProduct() throws SQLException {
        Statement statement = getStatement();
        return statement.execute("DELETE FROM product");
    }

}
