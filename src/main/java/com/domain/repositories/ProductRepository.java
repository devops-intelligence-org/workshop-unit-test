package com.domain.repositories;

import com.domain.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findProductByProductCode(String productCode);
    Product findProductByProductId(Long productId);
}
