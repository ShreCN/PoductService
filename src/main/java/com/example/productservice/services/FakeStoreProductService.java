package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.UserResponseDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    private RedisTemplate redisTemplate;

    FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate){
        this.restTemplate = restTemplate;
        this.redisTemplate= redisTemplate;
    }
    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto;
               Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCTS_"+id);
        if(product == null){
            fakeStoreProductDto =
                    restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
            product = convertDtoToProduct(fakeStoreProductDto);
            redisTemplate.opsForHash().put("PRODUCTS", "PRODUCTS_"+id, product);
        }

        return product;
    }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtoList
                = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDto currentProduct : fakeStoreProductDtoList){
            productList.add(convertDtoToProduct(currentProduct));
        }
        return productList;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto dto = convertProductToDto(product);
        dto = restTemplate.postForObject("https://fakestoreapi.com/products", dto, FakeStoreProductDto.class);
        return convertDtoToProduct(dto);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToDto(product);
        fakeStoreProductDto
                = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto, FakeStoreProductDto.class);

        return convertDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public Page<Product> searchProduct(int pageNumber, int pageSize) {
//        TODO
//        return restTemplate.getForObject("https://fakestoreapi.com/products/", Page.class);
        return null;
    }

    public void serviceDiscovery(){
        /* testing Eureka Service Discovery */
//        try {
            UserResponseDto userResponseDto =
                    restTemplate.getForObject("http://UserService/users/eureka", UserResponseDto.class);
//        } catch (Exception e) {
////            Throwable cause = e.getCause();
////            cause.printStackTrace(); // Log the actual cause of the exception
//            System.out.println(e.toString());
//        }
    }

    private Product convertDtoToProduct(FakeStoreProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Assuming Category needs only id and title, and title is derived from category field of DTO
//    Category category = new Category();
        // Here you would assign the id and title of the category appropriately.
        // For demonstration, let's assume the category title is what's passed in the DTO
        // and we set a dummy ID or fetch the correct ID based on the title from a database or other source
        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);

        return product;
    }

    private FakeStoreProductDto convertProductToDto(Product product) {
        if (product == null) {
            return null;
        }

        FakeStoreProductDto dto = new FakeStoreProductDto();

        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());

        // Assuming the category field in the DTO is a simple string title
        // and the Product's category object has a getTitle() method
        if(product.getCategory() != null)
            dto.setCategory(product.getCategory().getTitle());
        else dto.setCategory("null");

        return dto;
    }

}
