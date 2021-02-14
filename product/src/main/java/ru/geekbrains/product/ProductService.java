package ru.geekbrains.product;

import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private ProductContainer productContainer;

    public ProductContainer getProductContainer() {
        return productContainer;
    }

    public void setProductContainer(ProductContainer productContainer) {
        this.productContainer = productContainer;
    }

    public float getAverageCost() {
        float sum = 0;
        int size = productContainer.getProducts().size();
        if (size == 0) return 0;
        for (int i = 0; i < size; i++) {
            sum += productContainer.getProducts().get(i).getCost();
        }
        return sum / size;
    }

    public float getSize() {
        return productContainer.getProducts().size();
    }

    public ProductService(ProductContainer productContainer) {
        this.productContainer = productContainer;
    }

}
