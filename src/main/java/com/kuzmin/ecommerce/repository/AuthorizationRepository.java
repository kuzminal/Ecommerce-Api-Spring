package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.AuthorizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorizationRepository extends CrudRepository<AuthorizationEntity, UUID> {
}
