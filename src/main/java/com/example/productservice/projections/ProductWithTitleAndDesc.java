package com.example.productservice.projections;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWithTitleAndDesc { // for Hibernate and SQL Query Language
    private String title;
    private String description;
}
