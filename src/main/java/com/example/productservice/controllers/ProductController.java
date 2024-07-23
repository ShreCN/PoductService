package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.TokenService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private TokenService tokenService;

    public ProductController(ProductService productService, TokenService tokenService){    // Constructor Injection
        this.productService = productService;
        this.tokenService = tokenService;
    }

    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> getProductById(@RequestHeader("token") String token,  @PathVariable ("id") Long id){
//        if(!tokenService.validateToken(token)){
//            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
//        }
//        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
//    }
    public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/searchproducts")
    public Page<Product> searchProduct(@PathVariable("pageNumber") int pageNumber,
                                       @PathVariable("pageSize") int pageSize){
//        return productService.searchProduct(pageNumber, pageSize);
        return null;
    }

    /* calling user service to test Eureka Service Discovery */
    @GetMapping("/products/eureka")
    public void serviceDiscovery(){
        /* testing Eureka Service Discovery */
        productService.serviceDiscovery();
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
