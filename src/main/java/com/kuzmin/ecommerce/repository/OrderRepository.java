package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<OrderEntity, UUID>, OrderRepositoryExt {
    @Query("select o from OrderEntity o join o.userEntity u where u.id = :customerId")
    public Iterable<OrderEntity> findByCustomerId(@Param("customerId") UUID customerId);
}
