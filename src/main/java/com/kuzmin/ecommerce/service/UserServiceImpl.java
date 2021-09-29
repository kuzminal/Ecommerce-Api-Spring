package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.AddressEntity;
import com.kuzmin.ecommerce.domain.CardEntity;
import com.kuzmin.ecommerce.domain.UserEntity;
import com.kuzmin.ecommerce.repository.UserRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void deleteCustomerById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id) {
    return repository.findById(UUID.fromString(id)).map(UserEntity::getAddresses);
  }

  @Override
  public Iterable<UserEntity> getAllCustomers() {
    return repository.findAll();
  }

  @Override
  public Optional<CardEntity> getCardByCustomerId(String id) {
    return Optional.of(repository.findById(UUID.fromString(id)).map(UserEntity::getCard).get().get(0));
  }

  @Override
  public Optional<UserEntity> getCustomerById(String id) {
    return repository.findById(UUID.fromString(id));
  }
}
