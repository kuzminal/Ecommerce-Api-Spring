package com.kuzmin.ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    @Version
    private long version;

    public UUID getId() {
        return id;
    }

    public TagEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TagEntity setName(String name) {
        this.name = name;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
