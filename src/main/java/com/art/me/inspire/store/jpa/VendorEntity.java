package com.art.me.inspire.store.jpa;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "vendor",
        uniqueConstraints =
        @UniqueConstraint(
                name = DbConstants.UK_VENDOR_NAME,
                columnNames = {"id", "name"}))
@Access(AccessType.FIELD)
public class VendorEntity {

    public enum VendorType {GALLERY, HANDMADE_SHOP, COLLECTOR};

    @Id
    @Column(columnDefinition = "uuid")
    protected UUID id;

    @Length(min = 1)
    @Column(nullable = false)
    protected String name;

    @Enumerated(EnumType.STRING)
    protected VendorType type;

    public VendorEntity() {
    }

    public VendorEntity(UUID id, String name, VendorType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorType getType() {
        return type;
    }

    public void setType(VendorType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VendorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
