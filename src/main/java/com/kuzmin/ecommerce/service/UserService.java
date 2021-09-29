package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.AddressEntity;
import com.kuzmin.ecommerce.domain.CardEntity;
import com.kuzmin.ecommerce.domain.UserEntity;
import java.util.Optional;

public interface UserService {
  public void deleteCustomerById(String id);
  public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
  public Iterable<UserEntity> getAllCustomers();
  public Optional<CardEntity> getCardByCustomerId(String id);
  public Optional<UserEntity> getCustomerById(String id);
}
