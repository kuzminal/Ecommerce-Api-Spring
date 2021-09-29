package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.AuthorizationEntity;
import com.kuzmin.ecommerce.model.PaymentReq;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface PaymentService {

  public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);
  public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
