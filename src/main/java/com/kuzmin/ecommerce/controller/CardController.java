package com.kuzmin.ecommerce.controller;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.kuzmin.ecommerce.hateoas.CardRepresentationModelAssembler;
import com.kuzmin.ecommerce.model.Card;
import com.kuzmin.ecommerce.service.CardService;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.kuzmin.ecommerce.CardApi;
import com.kuzmin.ecommerce.model.AddCardReq;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController implements CardApi {

  private CardService service;
  private final CardRepresentationModelAssembler assembler;

  public CardController(CardService service, CardRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Void> deleteCardById(String id) {
    service.deleteCardById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<List<Card>> getAllCards() {
    return ok(assembler.toListModel(service.getAllCards()));
  }

  @Override
  public ResponseEntity<Card> getCardById(String id) {
    return service.getCardById(id).map(assembler::toModel)
        .map(ResponseEntity::ok).orElse(notFound().build());
  }

  @Override
  public ResponseEntity<Card> registerCard(@Valid AddCardReq addCardReq) {
    return status(HttpStatus.CREATED).body(service.registerCard(addCardReq).map(assembler::toModel).get());
  }
}
