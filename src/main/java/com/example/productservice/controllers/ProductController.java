package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){    // Constructor Injection
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable ("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }
    @PutMapping("/products/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return new Product();
    }
}
