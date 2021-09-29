package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "EXPIRES")
    private String expires;

    @Column(name = "CVV")
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "cardEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderEntity> orderEntities;

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public CardEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public CardEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getExpires() {
        return expires;
    }

    public CardEntity setExpires(String expires) {
        this.expires = expires;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public CardEntity setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public CardEntity setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orderEntities;
    }

    public CardEntity setOrders(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
