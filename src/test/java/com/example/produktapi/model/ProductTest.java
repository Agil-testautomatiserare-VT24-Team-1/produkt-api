package com.example.produktapi.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void getTitle() {
        Product product = new Product();
        product.setTitle("Product title");
        assertEquals(product.getTitle(), "Product title");
    }

    @Test
    void setImage_SetsCorrectImage() {
        Product product = new Product();
        String expectedImage = "image.jpg";
        product.setImage(expectedImage);
        String actualImage = product.getImage();
        Assertions.assertEquals(expectedImage, actualImage);
    }

    @Test
    void getImage_ReturnsCorrectImage() {
        Product product = new Product();
        assertNull(product.getImage(), "The image should be null when it is not set");
        String expectedImage = "image.jpg";
        product.setImage(expectedImage);
        String actualImage = product.getImage();
        Assertions.assertEquals(expectedImage, actualImage);
    }
}

