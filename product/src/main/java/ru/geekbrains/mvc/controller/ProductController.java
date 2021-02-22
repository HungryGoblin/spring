package ru.geekbrains.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.mvc.model.Product;
import ru.geekbrains.mvc.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String products(Model uiModel) throws Throwable {
        uiModel.addAttribute("products", productService.getProducts());
        return "all_products";
    }

    @GetMapping("/add")
    public String addProduct(@ModelAttribute Product product) throws Throwable {
        productService.addProduct(product);
        return "redirect:/products/all";
    }


}
