package com.kuzmin.ecommerce.controller;

import com.kuzmin.ecommerce.hateoas.ShipmentRepresentationModelAssembler;
import com.kuzmin.ecommerce.model.Shipment;
import com.kuzmin.ecommerce.service.ShipmentService;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import com.kuzmin.ecommerce.ShipmentApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController implements ShipmentApi {

  private ShipmentService service;
  private final ShipmentRepresentationModelAssembler assembler;

  public ShipmentController(ShipmentService service, ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<List<Shipment>> getShipmentByOrderId(@NotNull @Valid String id) {
    return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
  }
}
