package com.art.me.inspire.store.model;

import com.art.me.inspire.store.jpa.VendorEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class VendorInfo {

    public final UUID id;

    public final String name;

    public final VendorEntity.VendorType type;

    @JsonCreator
    public VendorInfo(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("type") VendorEntity.VendorType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorInfo that = (VendorInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    @Override
    public String toString() {
        return "VendorInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
