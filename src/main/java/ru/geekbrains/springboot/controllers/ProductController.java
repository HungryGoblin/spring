package ru.geekbrains.springboot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.springboot.services.ProductService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    ProductService productService = new ProductService();

    @GetMapping
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "all_products";
    }

    @GetMapping("/add")
    public String add() {
        return "add_product";
    }


    @GetMapping("/new")
    public String addProduct(Model model,
                             @RequestParam(required = true, name = "id") Integer id,
                             @RequestParam(required = true, name = "title") String title,
                             @RequestParam(required = true, name = "cost") Float cost) {
        productService.addProduct(id, title, cost);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, HttpServletResponse response) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}
