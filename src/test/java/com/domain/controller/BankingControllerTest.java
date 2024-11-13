package com.domain.controller;

import com.domain.models.Product;
import com.domain.models.ProductResponse;
import com.domain.repositories.ProductRepository;
import com.domain.util.DiferenciaEntreFechas;
import com.domain.util.Ping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
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
    void setUpMocks() {
        MockitoAnnotations.initMocks(bankingController);
    }

    @BeforeEach
    void setUp() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        mockProduct.setProductCode("AH");
        mockProduct.setIssueDate("23/11/2020");
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

    @BeforeEach
    void setUpById() {
        Optional<Product> mockProduct = Optional.of(new Product());
        mockProduct.get().setProductName("Cuenta de Ahorros");
        Mockito.when(productRepositoryMock.findById(1L)).thenReturn(mockProduct);
   }

   @Test
   void obtenerDetalleProductoConIdValido() {
       ResponseEntity<ProductResponse> respuestaServicio;
       respuestaServicio = bankingController.getProductDetailsById(1L);
       Assertions.assertEquals("Cuenta de Ahorros",respuestaServicio.getBody().getProductName());
   }
    
    @Test
    void obtenerDetalleProductoConCodigoInvalido() {
        ResponseEntity<ProductResponse> respuestaServicio;
        respuestaServicio = bankingController.getProductDetails("IT");
        Assertions.assertNull(respuestaServicio.getBody().getProductName());
    }


    @Test
    void testGetProductDetailsByIdNull() {
        ResponseEntity<ProductResponse> respuestaServicio;
        respuestaServicio = bankingController.getProductDetailsById(8L);
        Assertions.assertNull(respuestaServicio.getBody().getProductName());
    }
    
    @Test
    void testGetProductDetailsByIdResponse() {
        ResponseEntity<ProductResponse> respuestaServicio;
        respuestaServicio = bankingController.getProductDetailsById( 1L);
        assertEquals(HttpStatus.OK, respuestaServicio.getStatusCode());
    }

    @Test
    void testGetAllProducts() {
        List<Product> respuestaServicio;
        respuestaServicio = bankingController.getAllProducts();
        assertEquals(true,respuestaServicio.isEmpty());
    }

    Ping ping = new Ping();
    @Test
    void testPingResponse() throws IOException{
        String message ="Sent Ping Request to 127.0.0.1: Hurray! host is reachable"; 
        String respuestaPing = ping.sendPingRequest("127.0.0.1");
        assertEquals(message, respuestaPing);


    }

}