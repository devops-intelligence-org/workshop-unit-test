package com.domain.controller;


import java.util.Optional;
import java.io.IOException;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(BankingController.class);
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
        String message = "Get products list";
        logger.info(message);
        return (List<Product>) productRepository.findAll();

    }

    @GetMapping(path = "/product/code/{productCode}")
    public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productCode") String productCode) {
        product = Optional.of(new Product());
        productResponse = new ProductResponse();
        product = Optional.ofNullable(productRepository.findProductByProductCode(productCode.toUpperCase()));

        if (product.isPresent()) {
            productResponse.setClientName(product.get().getClientName());
            productResponse.setProductName(product.get().getProductName());
            productResponse.setProductLine(product.get().getProductLine());
            productResponse.setIssueDate(product.get().getIssueDate());

            Period period = diferenciaEntreFechas.calculateYearsOfIssue(product.get().getIssueDate());  
            productResponse.setDaysOfIssue(period.getDays());
            productResponse.setMonthsOfIssue(period.getMonths());
            productResponse.setYearsOfIssue(period.getYears());

            String message = "Get product code: "+productCode;
            logger.info(message);
        }
        return ResponseEntity.ok(productResponse);
        
    }

    @GetMapping(path = "/product/id/{productId}")
    public ResponseEntity<ProductResponse> getProductDetailsById(@PathVariable("productId") Long productId) {
        product = Optional.of(new Product());
        productResponse = new ProductResponse();
        product = productRepository.findById(productId);

        if (product.isPresent()) {
            productResponse.setProductId(product.get().getProductId());
            productResponse.setClientName(product.get().getClientName());
            productResponse.setProductName(product.get().getProductName());
            productResponse.setProductLine(product.get().getProductLine());
            productResponse.setIssueDate(product.get().getIssueDate());

            String message = "Get product Id: "+productId.toString();
            logger.info(message);
 
        }
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping(path = "/ping/{host}")
    public String pingResponse(@PathVariable("host") String host) throws IOException {
       return ping.sendPingRequest(host); 
    }


}