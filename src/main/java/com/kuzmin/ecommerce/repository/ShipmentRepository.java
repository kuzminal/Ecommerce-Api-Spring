package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.ShipmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShipmentRepository extends CrudRepository<ShipmentEntity, UUID> {
}
