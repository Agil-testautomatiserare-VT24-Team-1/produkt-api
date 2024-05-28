package com.example.produktapi.service;

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

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void getAllProducts() {
        // Implementation for this test method
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
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.empty());

        // Asserting that getProductById() method throws EntityNotFoundException
        assertThrows(EntityNotFoundException.class, () -> {
            productService.getProductById(1);
        });
    }
}


