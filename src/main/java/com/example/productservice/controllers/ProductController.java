package com.example.productservice.controllers;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductLimitReachedException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Product getProductById(@PathVariable ("id") Long id) throws ProductLimitReachedException {
        if(id > 100)
//        throw new RuntimeException();
            throw new ProductLimitReachedException();
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
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
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return new Product();
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> runtimeExceptionHandler(){
//        System.out.println("Runtime exception has occurred ");
//        return new ResponseEntity<>("Runtime exception has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
