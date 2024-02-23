package com.art.me.inspire.store.jpa;

import java.util.UUID;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "product",
      uniqueConstraints =
      @UniqueConstraint(
            name = DbConstants.UK_PRODUCT_NAME,
            columnNames = {"id", "name"}))
@Access(AccessType.FIELD)
public class ProductEntity {

      public enum ProductStatus { FOR_SALE, SOLD, RESERVED};

      @Id
      @Column(columnDefinition = "uuid")
      protected UUID id;

      @Length(min = 1)
      @Column(nullable = false)
      protected String name;

      @ManyToOne
      @JoinColumn(foreignKey = @ForeignKey(name = "fk_author"), nullable = false)
      protected AuthorEntity author;

      @ManyToOne
      @JoinColumn(foreignKey = @ForeignKey(name = "fk_vendor"))
      protected VendorEntity vendor;

      @Column
      protected double price;

      @Enumerated(EnumType.STRING)
      protected ProductStatus status;

      public ProductEntity() {
      }

      public ProductEntity(UUID id, String name, AuthorEntity author, VendorEntity vendor, double price, ProductStatus status) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.vendor = vendor;
            this.price = price;
            this.status = status;
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

      public AuthorEntity getAuthor() {
            return author;
      }

      public void setAuthor(AuthorEntity author) {
            this.author = author;
      }

      public VendorEntity getVendor() {
            return vendor;
      }

      public void setVendor(VendorEntity vendor) {
            this.vendor = vendor;
      }

      public double getPrice() {
            return price;
      }

      public void setPrice(double price) {
            this.price = price;
      }

      public ProductStatus getStatus() {
            return status;
      }

      public void setStatus(ProductStatus status) {
            this.status = status;
      }

      @Override
      public String toString() {
            return "ProductEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", author=" + author +
                    ", vendor=" + vendor +
                    ", price=" + price +
                    ", status=" + status +
                    '}';
      }
}
