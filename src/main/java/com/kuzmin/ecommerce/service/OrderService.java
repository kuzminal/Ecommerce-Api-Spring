package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.OrderEntity;
import com.kuzmin.ecommerce.model.NewOrder;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface OrderService {

  public Optional<OrderEntity> addOrder(@Valid NewOrder newOrder);
  public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
  public Optional<OrderEntity> getByOrderId(String id);
}
