package com.kuzmin.ecommerce.controller;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import com.kuzmin.ecommerce.CustomerApi;
import com.kuzmin.ecommerce.hateoas.AddressRepresentationModelAssembler;
import com.kuzmin.ecommerce.hateoas.CardRepresentationModelAssembler;
import com.kuzmin.ecommerce.hateoas.UserRepresentationModelAssembler;
import com.kuzmin.ecommerce.model.Address;
import com.kuzmin.ecommerce.model.Card;
import com.kuzmin.ecommerce.model.User;
import com.kuzmin.ecommerce.service.UserService;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi {

  private final UserRepresentationModelAssembler assembler;
  private final AddressRepresentationModelAssembler addrAssembler;
  private final CardRepresentationModelAssembler cardAssembler;
  private UserService service;

  public CustomerController(UserService service, UserRepresentationModelAssembler assembler,
      AddressRepresentationModelAssembler addrAssembler,
      CardRepresentationModelAssembler cardAssembler) {
    this.service = service;
    this.assembler = assembler;
    this.addrAssembler = addrAssembler;
    this.cardAssembler = cardAssembler;
  }

  @Override
  public ResponseEntity<Void> deleteCustomerById(String id) {
    service.deleteCustomerById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<List<Address>> getAddressesByCustomerId(String id) {
    return service.getAddressesByCustomerId(id).map(addrAssembler::toListModel)
        .map(ResponseEntity::ok).orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<User>> getAllCustomers() {
    return ok(assembler.toListModel(service.getAllCustomers()));
  }

  @Override
  public ResponseEntity<Card> getCardByCustomerId(String id) {
    return service.getCardByCustomerId(id).map(cardAssembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }

  @Override
  public ResponseEntity<User> getCustomerById(String id) {
    return service.getCustomerById(id).map(assembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }
}
