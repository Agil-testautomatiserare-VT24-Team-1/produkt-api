package com.example.produktapi.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllProducts() {
    }
    @Test
    void getId_ReturnsCorrectId() {

        Product product = new Product();
        Integer expectedId = 1;
        product.setId(expectedId);


        Integer actualId = product.getId();


        assertEquals(expectedId, actualId);
    }
    @Test
    void getId_ReturnsNullWhenIdNotSet() {

        Product product = new Product();


        Integer actualId = product.getId();


        assertNull(actualId, "The ID should be null when it is not set");
    }
}

