package ru.geekbrains.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.mvc.model.Product;
import ru.geekbrains.mvc.repo.InMemoryProductContainer;

import java.util.List;

@Component
public class ProductService {

    private InMemoryProductContainer products;

    @Autowired
    public void setProducts() {
        products = new InMemoryProductContainer();
    }

    public List<Product> getProducts() throws Throwable {
        return products.getProducts();
    }

    public Product getProduct(int id) throws Throwable {
        return products.getProduct(id);
    }

    public void addProduct(Product product) throws Throwable {
        products.addProduct(product);
    }

    public void deleteById(int id) {
        products.delProduct(id);
    }

}
