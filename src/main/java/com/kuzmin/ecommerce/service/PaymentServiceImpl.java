package com.kuzmin.ecommerce.service;

import com.kuzmin.ecommerce.domain.AuthorizationEntity;
import com.kuzmin.ecommerce.domain.OrderEntity;
import com.kuzmin.ecommerce.model.PaymentReq;
import com.kuzmin.ecommerce.repository.OrderRepository;
import com.kuzmin.ecommerce.repository.PaymentRepository;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  private PaymentRepository repository;
  private OrderRepository orderRepo;

  public PaymentServiceImpl(PaymentRepository repository, OrderRepository orderRepo) {
    this.repository = repository;
    this.orderRepo = orderRepo;
  }

  @Override
  public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq) {
    return Optional.empty();
  }

  @Override
  public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId) {
    return orderRepo.findById(UUID.fromString(orderId)).map(OrderEntity::getAuthorizationEntity);
  }

  /*private AuthorizationEntity toEntity(PaymentReq m) {
    PaymentEntity e = new PaymentEntity();
    e.setAuthorized(true).setMessage()
  }*/
}
