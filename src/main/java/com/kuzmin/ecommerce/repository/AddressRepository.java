package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {
}
