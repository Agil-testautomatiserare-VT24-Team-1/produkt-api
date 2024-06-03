package com.example.produktapi.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();

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
        assertEquals(id, actualId);
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
    void getTitle() {
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
    @Test
    void setPrice() {
        Double firstPrice = 12.34;
        Double newPrice = 56.78;
        product.setPrice(firstPrice);
        assertEquals(product.getPrice(), firstPrice);
        product.setPrice(newPrice);
        assertEquals(product.getPrice(), newPrice);
    }

    @Test
    void getPrice() {
        assertNull(product.getPrice(), "The price should be null when it is not set");
        Double expectedPrice = 12.34;
        product.setPrice(expectedPrice);
        assertEquals(product.getPrice(), expectedPrice);
    }

    @Test
    void getDescription_ReturnsCorrectDescription() {
        assertNull(product.getDescription(), "The description should be null when it is not set");
        String expectedDescription = "This is a product description";
        product.setDescription(expectedDescription);
        String actualDescription = product.getDescription();
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void setDescription_SetsCorrectDescription() {
        String expectedDescription = "This is a product description";
        product.setDescription(expectedDescription);
        String actualDescription = product.getDescription();
        assertEquals(expectedDescription, actualDescription);
    }
}