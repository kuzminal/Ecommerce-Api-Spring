package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
