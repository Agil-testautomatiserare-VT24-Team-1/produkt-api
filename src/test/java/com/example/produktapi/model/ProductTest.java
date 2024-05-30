package com.example.produktapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {

    Product product;
    @BeforeEach
    void setUp(){
        product = new Product();
    }
    @Test
    void getId_ReturnsCorrectId() {
        Integer expectedId = 1;
        product.setId(expectedId);
        Integer actualId = product.getId();
        assertEquals(expectedId, actualId);
    }
    @Test
    void getId_ReturnsNullWhenIdNotSet() {
        Integer actualId = product.getId();
        assertNull(actualId, "The ID should be null when it is not set");
    }

    @Test
    void getTitle(){
        product.setTitle("Product title");
        assertEquals(product.getTitle(), "Product title");
    }

    @Test
    void setPrice(){
        Double firstPrice = 12.34;
        Double newPrice = 56.78;
        product.setPrice(firstPrice);
        assertEquals(product.getPrice(), firstPrice);
        product.setPrice(newPrice);
        assertEquals(product.getPrice(), newPrice);
    }

    @Test
    void getPrice(){
        assertNull(product.getPrice(), "The price should be null when it is not set");
        Double expectedPrice = 12.34;
        product.setPrice(expectedPrice);
        assertEquals(product.getPrice(), expectedPrice);
    }
}

