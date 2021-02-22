package ru.geekbrains.springboot.services;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springboot.model.Product;
import ru.geekbrains.springboot.repositories.ProductRepository;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void addProduct(int id, String title, float cost) {
        productRepository.addProduct(new Product(id, title, cost));
    }


}
