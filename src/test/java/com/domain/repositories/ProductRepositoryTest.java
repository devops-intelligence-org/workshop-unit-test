package com.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.domain.models.Product;

class ProductRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindProductByProductCode() {

                // Arrange
        String productCode = "BD";
        Product mockProduct = new Product();
        mockProduct.setProductCode(productCode);
        mockProduct.setProductName("Billetera Digital");

        when(productRepository.findProductByProductCode(productCode)).thenReturn(mockProduct);

        // Act
        Product foundProduct = productRepository.findProductByProductCode(productCode);

        // Assert
        assertEquals(productCode, foundProduct.getProductCode());
        assertEquals("Billetera Digital", foundProduct.getProductName());

    }
}
