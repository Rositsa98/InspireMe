package com.art.me.inspire.store.model;

import com.art.me.inspire.store.jpa.ProductEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class ProductInfo {

    public final UUID id;

    public final String name;

    public final AuthorInfo author;

    public final VendorInfo vendor;

    public final double price;

    public final ProductEntity.ProductStatus status;

    @JsonCreator
    public ProductInfo(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("author") AuthorInfo author,
            @JsonProperty("vendor") VendorInfo vendor,
            @JsonProperty("price") double price,
            @JsonProperty("status") ProductEntity.ProductStatus status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.vendor = vendor;
        this.price = price;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                Objects.equals(vendor, that.vendor) &&
                Objects.equals(price, that.price) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, vendor, price, status);
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", vendor=" + vendor +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
