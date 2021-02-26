package ru.hiber.springboot.repositories;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.hiber.springboot.exceptions.ProductNotFoundException;
import ru.hiber.springboot.model.Product;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Data
@Component
public class ProductRepository {

private HashMap<Integer, Product> products;
    // почему-то не работает POstConstruct, вынес звапуск инициализации в конструктор
    @PostConstruct
    public void init() {
        products = new HashMap<>();
        products.put(0, new Product(0, "iPhone X", 600));
        products.put(1, new Product(1, "iPhone 11", 700));
        products.put(2, new Product(2, "iPhone 12", 800));
    }

    public HashMap<Integer, Product> getAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void deleteProduct(int id) {
        if (!products.containsKey(id)) throw
            new ProductNotFoundException(String.format("Отсутствует продукт с идентификатором: %d", id));
        products.remove(id);
    }

    public ProductRepository() {
        init();
    }

}
