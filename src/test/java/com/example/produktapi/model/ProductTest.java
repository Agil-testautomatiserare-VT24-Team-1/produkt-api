package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setIdTest() {
        Product theProduct = new Product();
        int id = 1;
        theProduct.setId(id);
        int actualId = theProduct.getId();
        Assertions.assertEquals(id, actualId);
    }

}
