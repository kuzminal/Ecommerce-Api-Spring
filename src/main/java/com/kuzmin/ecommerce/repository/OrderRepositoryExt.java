package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.OrderEntity;
import com.kuzmin.ecommerce.model.NewOrder;

import java.util.Optional;

public interface OrderRepositoryExt {
    Optional<OrderEntity> insert(NewOrder m);
}
