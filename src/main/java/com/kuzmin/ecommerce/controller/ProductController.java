package com.kuzmin.ecommerce.controller;

import com.kuzmin.ecommerce.ProductApi;
import com.kuzmin.ecommerce.hateoas.ProductRepresentationModelAssembler;
import com.kuzmin.ecommerce.model.Product;
import com.kuzmin.ecommerce.service.ProductService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ProductController implements ProductApi {
    private ProductService service;
    private final ProductRepresentationModelAssembler assembler;

    public ProductController(ProductService service, ProductRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<Product> getProduct(String id) {
        return service.getProduct(id)
                .map(assembler::toModel)
                .map(product -> ResponseEntity.ok().cacheControl(
                                CacheControl.maxAge(5, TimeUnit.DAYS))
                        .eTag(Long.toString(product.getVersion()))
                        .body(product)).orElse(notFound().build());
    }

    @Override
    public ResponseEntity<List<Product>> queryProducts(@Valid String tag, @Valid String name,
                                                       @Valid Integer page, @Valid Integer size) {
        return ok(assembler.toListModel(service.getAllProducts()));
    }
}
