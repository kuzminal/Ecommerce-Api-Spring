package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.ProductEntity;
import java.util.Optional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ProductService {
  @NotNull Iterable<ProductEntity> getAllProducts();
  Optional<ProductEntity> getProduct(String id);
}