package com.domain.controller;

import com.domain.models.Product;
import com.domain.models.ProductResponse;
import com.domain.repositories.ProductRepository;
import com.domain.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

class BankingControllerTest {

    @Autowired
    ProductResponse productResponse;
    @Autowired
    Optional<Product> product;

    ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();

    @Autowired
    BankingController bankingController = new BankingController(productRepositoryMock,diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        Product mockProduct = new Product();
        mockProduct.setProductCode("AH");
        mockProduct.setIssueDate("23/11/2020");
        mockProduct.setProductId((long) 1);
        mockProduct.setProductName("Cuenta de Ahorros");
        mockProduct.setProductLine("Ahorros");
        Mockito.when(productRepositoryMock.findProductByProductCode("AH")).thenReturn(mockProduct);

    }

    @Test
    void obtenerDetalleProductoConCodigoValido() {
        ResponseEntity<ProductResponse> respuestaServicio;
        respuestaServicio = bankingController.getProductDetails("AH");
        Assertions.assertEquals("Cuenta de Ahorros",respuestaServicio.getBody().getProductName());
    }

    @Test
    void obtenerDetalleProductoConCodigoInvalido() {
        ResponseEntity<ProductResponse> respuestaServicio;
        respuestaServicio = bankingController.getProductDetails("IT");
        Assertions.assertNull(respuestaServicio.getBody().getProductName());
    }


}