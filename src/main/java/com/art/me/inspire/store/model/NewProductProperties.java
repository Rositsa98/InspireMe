package com.art.me.inspire.store.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class NewProductProperties {

    public final String name;
    public final UUID authorId;
    public final UUID vendorId;
    public final Double price;

    @JsonCreator
    public NewProductProperties(
            @JsonProperty("name") String name,
            @JsonProperty("authorId") UUID authorId,
            @JsonProperty("vendorId") UUID vendorId,
            @JsonProperty("price") Double price) {
        this.name = name;
        this.authorId = authorId;
        this.vendorId = vendorId;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewProductProperties that = (NewProductProperties) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(vendorId, that.vendorId) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorId, vendorId, price);
    }

    @Override
    public String toString() {
        return "NewProductProperties{" +
                "name='" + name + '\'' +
                ", authorId=" + authorId +
                ", vendorId=" + vendorId +
                ", price=" + price +
                '}';
    }
}
