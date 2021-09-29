package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity userEntity;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "CART_ITEM",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<ItemEntity> itemEntities = Collections.emptyList();

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public CartEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public CartEntity setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public List<ItemEntity> getItems() {
        return itemEntities;
    }

    public CartEntity setItems(List<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return version == that.version && Objects.equals(id, that.id) && Objects.equals(userEntity, that.userEntity) && Objects.equals(itemEntities, that.itemEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity, itemEntities, version);
    }
}
