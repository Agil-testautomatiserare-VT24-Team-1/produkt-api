package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    void getTitle(){
        Product product = new Product();
        product.setTitle("Product title");
        assertEquals(product.getTitle(), "Product title");
    }
    @Test
    void getCategoryReturnsCorrectCategory() {

        String expectedCategory = "jewellery";
        Product product = new Product();
        product.setCategory(expectedCategory);
        String actualCategory = product.getCategory();
        assertEquals(expectedCategory, actualCategory );
    }
    @Test
    void getCategoryReturnsNullWhenCategoryNotSet() {

        Product product = new Product();
        String actualCategory = product.getCategory();
        assertNull(actualCategory, "The category should be null when it is not set");
    }
    @Test
    public void testDefaultConstructor() {

        Product product = new Product();
        assertNotNull(product);
    }

    @Test
    public void testParameterizedConstructor() {
        // Arrange
        String title = "Test Product";
        Double price = 10.99;
        String category = "Test Category";
        String description = "Test Description";
        String image = "test.jpg";
        Product product = new Product(title, price, category, description, image);
        assertNotNull(product);
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
        assertEquals(category, product.getCategory());
        assertEquals(description, product.getDescription());
        assertEquals(image, product.getImage());
    }
}


