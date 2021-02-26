package ru.geekbrains.springboot.repositories;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.springboot.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Data
@Component
public class ProductRepository {

    private ArrayList<Product> products;

    // почему-то не работает POstConstruct, вынес звапуск инициализации в конструктор
    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(0, "iPhone X", 600));
        products.add(new Product(1, "iPhone 11", 700));
        products.add(new Product(2, "iPhone 12", 800));
    }

    public ArrayList getAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(int id) {
        products.remove(id);
    }

    public ProductRepository() {
        init();
    }
}
