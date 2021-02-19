package ru.geekbrains.mvc.repo;

import org.springframework.stereotype.Component;
import ru.geekbrains.mvc.model.Product;

import java.util.List;

@Component
public interface ProductContainer {

    List<Product> getProducts();

}
