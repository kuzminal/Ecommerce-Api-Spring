package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name="AUTHORIZED")
    private boolean authorized;

    @Column(name = "MESSAGE")
    private String message;

    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public PaymentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public PaymentEntity setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PaymentEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
