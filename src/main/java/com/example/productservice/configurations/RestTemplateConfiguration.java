package com.example.productservice.configurations;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced // balance load for call between two microservices
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        // Patch is supported by RestTemplate, so create instance of HttpComponentsClientHttpRequestFactory
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.setMessageConverters(Collections.singletonList(new StringHttpMessageConverter(StandardCharsets.UTF_8)));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
