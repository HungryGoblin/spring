package ru.hiber.springboot.services;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hiber.springboot.model.Product;
import ru.hiber.springboot.repositories.ProductRepository;

import java.util.HashMap;

@Service
@NoArgsConstructor
public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public HashMap<Integer, Product> getAll() {
        return productRepository.getAll();
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void addProduct(int id, String title, float cost) {
        productRepository.addProduct(new Product(id, title, cost));
    }


}
