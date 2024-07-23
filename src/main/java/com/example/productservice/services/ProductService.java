package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

      Product getProductById(Long id);

      List<Product> getAllProducts();

      Product createProduct(Product product);

      Product replaceProduct(Long id, Product product);

      Product updateProduct( Long id, Product product);

      Product deleteProduct(Long id);
      Page<Product> searchProduct(int pageNumber, int pageSize);

      void serviceDiscovery();
}
