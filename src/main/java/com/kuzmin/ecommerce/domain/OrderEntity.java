package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import com.kuzmin.ecommerce.model.Order.StatusEnum;

@Entity
@Table(name = "orderEntities")
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID", nullable=false)
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID", insertable=false, updatable=false)
    private AddressEntity addressEntity;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
    private PaymentEntity paymentEntity;

    @JoinColumn(name = "SHIPMENT_ID", referencedColumnName = "ID")
    @OneToOne
    private ShipmentEntity shipmentEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CARD_ID", referencedColumnName = "ID")
    private CardEntity cardEntity;

    @Column(name = "ORDER_DATE")
    private Timestamp orderDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "ORDER_ITEM",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<ItemEntity> itemEntities = Collections.emptyList();

    @OneToOne(mappedBy = "orderEntity")
    private AuthorizationEntity authorizationEntity;

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public OrderEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public OrderEntity setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OrderEntity setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public OrderEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public OrderEntity setAddress(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
        return this;
    }

    public PaymentEntity getPayment() {
        return paymentEntity;
    }

    public OrderEntity setPayment(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
        return this;
    }

    public ShipmentEntity getShipments() {
        return shipmentEntity;
    }

    public OrderEntity setShipments(ShipmentEntity shipmentEntity) {
        this.shipmentEntity = shipmentEntity;
        return this;
    }

    public CardEntity getCardEntity() {
        return cardEntity;
    }

    public OrderEntity setCard(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
        return this;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public OrderEntity setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public List<ItemEntity> getItems() {
        return itemEntities;
    }

    public OrderEntity setItems(List<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
        return this;
    }

    public AuthorizationEntity getAuthorizationEntity() {
        return authorizationEntity;
    }

    public OrderEntity setAuthorization(
            AuthorizationEntity authorizationEntity) {
        this.authorizationEntity = authorizationEntity;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", total=" + total +
                ", status=" + status +
                ", userEntity=" + userEntity +
                ", addressEntity=" + addressEntity +
                ", paymentEntity=" + paymentEntity +
                ", shipmentEntity=" + shipmentEntity +
                ", cardEntity=" + cardEntity +
                ", orderDate=" + orderDate +
                ", itemEntities=" + itemEntities +
                ", authorizationEntity=" + authorizationEntity +
                ", version=" + version +
                '}';
    }
}
