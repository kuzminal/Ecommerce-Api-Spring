package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "User name is required.")
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "USER_STATUS")
    private String userStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private List<AddressEntity> addressEntities = Collections.emptyList();;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CardEntity> cardEntities;

    @OneToOne(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private CartEntity cartEntity;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderEntity> orderEntities;

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public UserEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public UserEntity setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public List<AddressEntity> getAddresses() {
        return addressEntities;
    }

    public UserEntity setAddresses(
            List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
        return this;
    }

    public List<CardEntity> getCard() {
        return cardEntities;
    }

    public UserEntity setCard(List<CardEntity> cardEntity) {
        this.cardEntities = cardEntity;
        return this;
    }

    public CartEntity getCart() {
        return cartEntity;
    }

    public UserEntity setCart(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
        return this;
    }

    public List<OrderEntity> getOrder() {
        return orderEntities;
    }

    public UserEntity setOrder(List<OrderEntity> orderEntity) {
        this.orderEntities = orderEntity;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
