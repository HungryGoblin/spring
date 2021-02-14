package ru.geekbrains.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryProductContainer implements ProductContainer {

    ArrayList<Product> products = null;

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

}
