package com.Product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Product.Model.Product;
import com.Product.Service.ProductService;

import org.springframework.ui.Model;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/save")
    public String addProduct( Product product) {
        productService.saveProduct(product);
        return "redirect:/display";
    }

    @GetMapping("/display")
    public String displayProducts(Model model) {
        List<Product> product = productService.getAllProducts();
        model.addAttribute("products", product);
        return "display-products";
    }
}