package ru.geekbrains.mvc.repo;

import org.springframework.stereotype.Component;
import ru.geekbrains.mvc.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class InMemoryProductContainer implements ProductContainer {

    ArrayList<Product> products;

    @PostConstruct
    public void init(ArrayList<Product> products) {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 10", 500));
        products.add(new Product(2, "Iphone 11", 600));
        products.add(new Product(3, "Iphone X", 700));
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct (Product product) {
        products.add(product);
    }

    public void delProduct (int id) {
        products.remove(id);
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

}
