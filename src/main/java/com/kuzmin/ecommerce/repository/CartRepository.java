package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends CrudRepository<CartEntity, UUID> {
    @Query("select c from CartEntity c join c.userEntity u where u.id = :customerId")
    public Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);
}
