package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, UUID> {
}
