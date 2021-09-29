package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.AddressEntity;
import com.kuzmin.ecommerce.model.AddAddressReq;
import java.util.Optional;

public interface AddressService {
  public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq);
  public void deleteAddressesById(String id);
  public Optional<AddressEntity> getAddressesById(String id);
  public Iterable<AddressEntity> getAllAddresses();
}
