package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {
}
