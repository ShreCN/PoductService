package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductLimitReachedException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
public class ProductControllerMVCTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//    public void testGetProductById() throws Exception {
//
//        // Arrange
//        Product product = new Product();
//        product.setId(1L);
//        product.setTitle("Test Product");
//        product.setDescription("This is a Test Product");
//        product.setPrice(10.0);
//        // Mockito
//        when(productService.getProductById(any(Long.class))).thenReturn(product);
//
//        // Act and Assert
//        mockMvc.perform(get("/products/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.title").value("Test Product"))
//                .andExpect(jsonPath("$.description").value("This is a Test Product"))
//                .andExpect(jsonPath("$.price").value(10.0));
//
//    }
//
////    @Test
////    public void testGetProductById_NotFound() throws Exception {
////        // Mockito
////        when(productService.getProductById(any(Long.class)))
////                .thenThrow(new RuntimeException("Product Not Found"));
////
////        // Act and Assert
////        mockMvc.perform(get("/products/1")
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.error").value("Product Not Found"));
////
////    }
}
