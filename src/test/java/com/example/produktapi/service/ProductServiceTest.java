package com.example.produktapi.service;

import com.example.produktapi.exception.BadRequestException;
import com.example.produktapi.exception.EntityNotFoundException;
import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    // AutoCloseable resource for MockitoAnnotations.openMocks()
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    void getProductByIdSuccess() {
        Product product = new Product(
                "jewellery",
                100.0,
                "jewellery",
                "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
                "image"
        );

        when(productRepository.findById(any())).thenReturn(Optional.of(product));

        Product productById = productService.getProductById(1);
        assertNotNull(productById);
        assertEquals(productById.getTitle(),"jewellery");
    }
    @Test
    void getProductByIdNegative(){
        when(productRepository.findById(any())).thenReturn(Optional.empty());

        // Asserting that getProductById() method throws EntityNotFoundException
        assertThrows(EntityNotFoundException.class, () -> {
            productService.getProductById(1);
        });
    }
    @Test
    void addProduct_ProductDoesNotExist_SavesProduct() {
        // Arrange
        when(productRepository.findByTitle(any())).thenReturn(Optional.empty());

        Product newProduct = new Product("2", 200.0, "jewellery", "New Title", "image");
        when(productRepository.save(any(Product.class))).thenReturn(newProduct);

        // Act
        Product savedProduct = productService.addProduct(newProduct);

        // Assert
        assertNotNull(savedProduct);
        assertEquals("2", savedProduct.getTitle());
        assertEquals(200.0, savedProduct.getPrice());
    }
    @Test
    void addProduct_ProductAlreadyExists_ThrowsBadRequestException() {
        // Arrange
        Product existingProduct = new Product("1", 100.0, "jewellery", "Existing Title", "image");
        when(productRepository.findByTitle(any())).thenReturn(Optional.of(existingProduct));

        Product newProduct = new Product("2", 200.0, "jewellery", "Existing Title", "image");

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            productService.addProduct(newProduct);
        });

        assertEquals("En produkt med titeln: 2 finns redan", exception.getMessage());
    }

    @Test

    void testGetAllProducts() {

        Product product1 ;
        Product product2 ;

        product1 = new Product("1", 100.0, "jewellery", "Product 1", "image1");
        product2 = new Product("2", 200.0, "jewellery", "Product 2", "image2");
        List<Product> productList = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(product1.getId(), result.get(0).getId());
        assertEquals(product1.getTitle(), result.get(0).getTitle());
        assertEquals(product2.getId(), result.get(1).getId());
        assertEquals(product2.getTitle(), result.get(1).getTitle());

        verify(productRepository, times(1)).findAll();
    }
    
    void getProductsByCategory_ReturnsCorrectProducts() {
        // Arrange
        Product product1 = new Product("Product 1", 100.0, "electronics", "Description 1", "image1.jpg");
        Product product2 = new Product("Product 2", 200.0, "electronics", "Description 2", "image2.jpg");
        List<Product> expectedProducts = Arrays.asList(product1, product2);
        when(productRepository.findByCategory("electronics")).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productService.getProductsByCategory("electronics");

        // Assert
        assertEquals(expectedProducts, actualProducts);

    }
}



