package com.example.produktapi.model;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest { 
    
    //Göran Ahlgren
    Product product;
    
    //Göran Ahlgren
    @BeforeEach
    void setUp() {
        product = new Product();
    }
    
    //Göran Ahlgren
    @AfterEach
    void tearDown() {
    }

    //Göran Ahlgren
    @Test  
    void setIdTest() {
        Product theProduct = new Product();
        int id = 1;
        theProduct.setId(id);
        int actualId = theProduct.getId();
        assertEquals(id, actualId);
    }

    @Test  //apurva
    void getId_ReturnsCorrectId() {
        Integer expectedId = 1;
        product.setId(expectedId);
        Integer actualId = product.getId();
        assertEquals(expectedId, actualId);
    }

    @Test //apurva
    void getId_ReturnsNullWhenIdNotSet() {
        Product product = new Product();
        Integer actualId = product.getId();
        assertNull(actualId, "The ID should be null when it is not set");
    }

    //David Galstyan
    @Test
    void getTitle(){
        product = new Product("Title", 33.33, "Category", "Description", "Image");
        Assert.assertEquals(product.getTitle(), "Title");
    }

    //David Galstyan
    @Test
    void getTitleNull(){
        String productTitle = null;
        product.setTitle(productTitle);
        assertNull(product.getTitle());
    }

    //David Galstyan
    @Test
    void setTitle() {
        String productTitle = "Product title";
        product.setTitle(productTitle);
        assertEquals(product.getTitle(), productTitle);
    }

    @Test //apurva
    void getCategoryReturnsCorrectCategory() {
        String expectedCategory = "jewellery";
        Product product = new Product();
        product.setCategory(expectedCategory);
        String actualCategory = product.getCategory();
        assertEquals(expectedCategory, actualCategory);
    }

    @Test  //apurva
    void getCategoryReturnsNullWhenCategoryNotSet() {
        Product product = new Product();
        String actualCategory = product.getCategory();
        assertNull(actualCategory, "The category should be null when it is not set");
    }

    @Test  //apurva
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

    @Test       //Ninis
    void setImage_SetsCorrectImage() {
        Product product = new Product();
        String expectedImage = "image.jpg";
        product.setImage(expectedImage);
        String actualImage = product.getImage();
        Assertions.assertEquals(expectedImage, actualImage);
    }

    @Test       //Ninis
    void getImage_ReturnsCorrectImage() {
        Product product = new Product();
        assertNull(product.getImage(), "The image should be null when it is not set");
        String expectedImage = "image.jpg";
        product.setImage(expectedImage);
        String actualImage = product.getImage();
        Assertions.assertEquals(expectedImage, actualImage);
    }

    //Göran Ahlgren
    @Test
    void setPrice() {
        Double firstPrice = 12.34;
        Double newPrice = 56.78;
        product.setPrice(firstPrice);
        assertEquals(product.getPrice(), firstPrice);
        product.setPrice(newPrice);
        assertEquals(product.getPrice(), newPrice);
    }

    //Göran Ahlgren
    @Test
    void getPrice() {
        assertNull(product.getPrice(), "The price should be null when it is not set");
        Double expectedPrice = 12.34;
        product.setPrice(expectedPrice);
        assertEquals(product.getPrice(), expectedPrice);
    }

    @Test       //Ninis
    void getDescription_ReturnsCorrectDescription() {
        assertNull(product.getDescription(), "The description should be null when it is not set");
        String expectedDescription = "This is a product description";
        product.setDescription(expectedDescription);
        String actualDescription = product.getDescription();
        assertEquals(expectedDescription, actualDescription);
    }

    @Test       //Ninis
    void setDescription_SetsCorrectDescription() {
        String expectedDescription = "This is a product description";
        product.setDescription(expectedDescription);
        String actualDescription = product.getDescription();
        assertEquals(expectedDescription, actualDescription);
    }
}

