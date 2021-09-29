package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.CardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardRepository  extends CrudRepository<CardEntity, UUID> {
}
