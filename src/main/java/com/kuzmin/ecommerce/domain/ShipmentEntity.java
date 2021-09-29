package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "shipment")
public class ShipmentEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "EST_DELIVERY_DATE")
    private Timestamp estDeliveryDate;

    @Column(name = "CARRIER")
    private String carrier;

    public UUID getId() {
        return id;
    }

    public ShipmentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    @Version
    private long version;

    public Timestamp getEstDeliveryDate() {
        return estDeliveryDate;
    }

    public ShipmentEntity setEstDeliveryDate(Timestamp estDeliveryDate) {
        this.estDeliveryDate = estDeliveryDate;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public ShipmentEntity setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
