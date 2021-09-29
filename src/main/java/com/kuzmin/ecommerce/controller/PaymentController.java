package com.kuzmin.ecommerce.controller;

import com.kuzmin.ecommerce.hateoas.PaymentRepresentationModelAssembler;
import com.kuzmin.ecommerce.model.Authorization;
import com.kuzmin.ecommerce.model.PaymentReq;
import com.kuzmin.ecommerce.service.PaymentService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.kuzmin.ecommerce.PaymentApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController implements PaymentApi {

  private PaymentService service;
  private final PaymentRepresentationModelAssembler assembler;

  public PaymentController(PaymentService service, PaymentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Authorization> authorize(@Valid PaymentReq paymentReq) {
    return null;
  }

  @Override
  public ResponseEntity<Authorization> getOrdersPaymentAuthorization(
      @NotNull @Valid String id) {
    return null;
  }
}
