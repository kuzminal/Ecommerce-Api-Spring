package com.kuzmin.ecommerce.repository;

import com.kuzmin.ecommerce.domain.TagEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TagRepository extends CrudRepository<TagEntity, UUID> {
}
