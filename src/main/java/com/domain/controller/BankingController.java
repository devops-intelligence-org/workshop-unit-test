package com.domain.controller;


import java.util.Optional;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.models.Product;
import com.domain.models.ProductResponse;
import com.domain.repositories.ProductRepository;
import com.domain.util.DiferenciaEntreFechas;
import com.domain.util.Ping;

@RestController()
@RequestMapping("/api/v1")
public class BankingController {

    ProductResponse productResponse;
    Optional<Product> product;
    ProductRepository productRepository;
    DiferenciaEntreFechas diferenciaEntreFechas;
    Ping ping = new Ping();

    public BankingController(ProductRepository productRepository,DiferenciaEntreFechas diferenciaEntreFechas) {
        this.productRepository = productRepository;
        this.diferenciaEntreFechas = diferenciaEntreFechas;
    }


    @GetMapping(path = "/product")
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();

    }

    @GetMapping(path = "/product/{productCode}")
    public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productCode") String productCode) {
        product = Optional.of(new Product());
        productResponse = new ProductResponse();
        product = Optional.ofNullable(productRepository.findProductByProductCode(productCode.toUpperCase()));

        if (product.isPresent()) {
            productResponse.setClientName(product.get().getClientName());
            productResponse.setProductName(product.get().getProductName());
            productResponse.setProductLine(product.get().getProductLine());
            productResponse.setIssueDate(product.get().getIssueDate());
  
        }
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping(path = "/ping")
    public String pingResponse() throws UnknownHostException, IOException {
       String host = "kyndryl.com"; 
       return ping.sendPingRequest(host); 
    }


}