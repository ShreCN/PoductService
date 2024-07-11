package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductWithTitleAndDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    void delete(Product product);

    Product save(Product product);

    // Hibernate Query Language (alias is a must)
    @Query("select p.title as title, p.description as description from Product p where p.id=:id")
    ProductWithTitleAndDesc hibernateQueryForProduct(@Param("id") Long id);

    // MySQL Query Language
    @Query(value = "select title, description from Product where id = :id", nativeQuery = true)
    ProductWithTitleAndDesc sqlQueryForProduct(@Param("id") Long id);
}
