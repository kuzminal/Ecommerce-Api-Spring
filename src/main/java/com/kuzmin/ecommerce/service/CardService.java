package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.CardEntity;
import com.kuzmin.ecommerce.model.AddCardReq;
import java.util.Optional;
import javax.validation.Valid;

public interface CardService {
  public void deleteCardById(String id);
  public Iterable<CardEntity> getAllCards();
  public Optional<CardEntity> getCardById(String id);
  public Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq);
}
