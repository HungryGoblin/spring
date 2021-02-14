package ru.geekbrains.product;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductContainer {

    List<Product> getProducts();

}
