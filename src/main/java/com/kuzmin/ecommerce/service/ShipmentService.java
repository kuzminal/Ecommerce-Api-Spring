package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.ShipmentEntity;
import javax.validation.constraints.Min;

public interface ShipmentService {
  public Iterable<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
