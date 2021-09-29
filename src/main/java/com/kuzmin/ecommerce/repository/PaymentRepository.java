package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}
