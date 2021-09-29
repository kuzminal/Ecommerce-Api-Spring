package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private ProductEntity productEntity;

    @Column(name = "UNIT_PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToMany(mappedBy = "itemEntities", fetch = FetchType.LAZY)
    private List<CartEntity> cartEntity;

    @ManyToMany(mappedBy = "itemEntities", fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntities;

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public ItemEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public ItemEntity setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

   /* public Cart getCart() {
        return cart;
    }

    public ItemEntity setCart(Cart cart) {
        this.cart = cart;
        return this;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return quantity == that.quantity && version == that.version && Objects.equals(id, that.id) && Objects.equals(productEntity, that.productEntity) && Objects.equals(price, that.price) && Objects.equals(cartEntity, that.cartEntity) && Objects.equals(orderEntities, that.orderEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productEntity, price, quantity, cartEntity, orderEntities, version);
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", productEntity=" + productEntity +
                ", price=" + price +
                ", quantity=" + quantity +
                ", cartEntity=" + cartEntity +
                ", orderEntities=" + orderEntities +
                ", version=" + version +
                '}';
    }

    public List<CartEntity> getCart() {
        return cartEntity;
    }

    public ItemEntity setCart(List<CartEntity> cartEntity) {
        this.cartEntity = cartEntity;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orderEntities;
    }

    public ItemEntity setOrders(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
        return this;
    }
}
