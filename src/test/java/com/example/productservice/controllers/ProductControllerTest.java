package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductLimitReachedException;
import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.SelfProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@SpringBootTest
class ProductControllerTest {

//    @MockBean
//    ProductService productService;
//
////    @MockBean
////    FakeStoreProductService fakeStoreProductService;
//
//    @Autowired
//    ProductController productController;
//
//    @Test
//    @BeforeEach // will be called before each test case
//    void setUp(){
//        // Arrange
//        Product product = new Product();
//        product.setId(2L);
//        product.setTitle("MacBook");
//
//        // Mockito Rule
//        when(productService.getProductById(any(Long.class)))
//                .thenReturn(product);
//    }
//
////    @Test // Positive Test Case - Happy Path
////    void Test_WhenGetProductByIdIsCalled_ThenReturnProduct() throws ProductLimitReachedException {
////        // Arrange
//////        Product product = new Product();
//////        product.setId(2L);
//////        product.setTitle("MacBook");
////
////        // Mockito Rule
//////        when(productService.getProductById(any(Long.class)))
//////                .thenReturn(product);
////
////        // Act
////        ResponseEntity<Product> responseEntity = productController.getProductById(2L);
////
////        // Assert
////        assertNotNull(responseEntity);
////        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
////        assertNotNull(responseEntity.getBody());
////        assertEquals(2L, responseEntity.getBody().getId());
////        assertEquals("MacBook", responseEntity.getBody().getTitle());
////    }
////
////    @Test // Negative Test Case
////    void Test_WhenGetProductById_Then_ReturnException() throws ProductLimitReachedException {
////        // Mockito Rule - Local rule will take precedence over the Global Rule
////        when(productService.getProductById(any(Long.class)))
////                .thenThrow(new RuntimeException("Something went wrong"));
////
////        // Assert
////        assertThrows(RuntimeException.class, () -> productController.getProductById(2L));
////    }
//
//
////    @Test
////    void Test_WhenGetProductById_Then_CallRealMethod() throws ProductLimitReachedException {
////
////        // Mockito Rule
////        when(fakeStoreProductService.getProductById(any(Long.class)))
////                .thenCallRealMethod();
////
////        // Act
////        ResponseEntity<Product> responseEntity = productController.getProductById(2L);
////
////        // Assert
////        assertNotNull(responseEntity);
////        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
////        assertNotNull(responseEntity.getBody());
////        assertEquals(2L, responseEntity.getBody().getId());
////        assertEquals("MacBook", responseEntity.getBody().getTitle());
////    }
}