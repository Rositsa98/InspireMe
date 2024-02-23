package com.art.me.inspire.store.repo;

import com.art.me.inspire.store.jpa.AuthorEntity;
import com.art.me.inspire.store.jpa.AuthorRepository;
import com.art.me.inspire.store.jpa.ProductEntity;
import com.art.me.inspire.store.jpa.ProductRepository;
import com.art.me.inspire.store.jpa.VendorEntity;
import com.art.me.inspire.store.jpa.VendorRepository;
import com.art.me.inspire.store.model.AuthorInfo;
import com.art.me.inspire.store.model.NewProductProperties;
import com.art.me.inspire.store.model.ProductInfo;
import com.art.me.inspire.store.model.VendorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for {@link com.art.me.inspire.store.jpa.ProductEntity}
 */
@Repository
public class ProductRepo {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected AuthorRepository authorRepository;

    @Autowired
    protected VendorRepository vendorRepository;


    public ProductInfo addProduct(NewProductProperties productProperties) {
        AuthorEntity author = null;
        if (productProperties.authorId != null) {
            Optional<AuthorEntity> authorEntity = authorRepository.findById(productProperties.authorId);
            author = authorEntity.orElse(null);
        }

        VendorEntity vendor = null;
        if (productProperties.vendorId != null) {
            Optional<VendorEntity> vendorEntity = vendorRepository.findById(productProperties.vendorId);
            vendor = vendorEntity.orElse(null);
        }

        ProductEntity productEntity = new ProductEntity(UUID.randomUUID(), productProperties.name,
                author,
                vendor,
                productProperties.price,
                ProductEntity.ProductStatus.FOR_SALE
        );
        return toProductInfo(productRepository.save(productEntity));
    }

    protected ProductInfo toProductInfo(ProductEntity productEntity) {
        AuthorEntity author = productEntity.getAuthor();
        VendorEntity vendor = productEntity.getVendor();

        return new ProductInfo(productEntity.getId(),
                productEntity.getName(),
                new AuthorInfo(author.getId(), author.getName(), author.getPeriod()),
                vendor != null ? new VendorInfo(vendor.getId(), vendor.getName(), vendor.getType()) : null,
                productEntity.getPrice(),
                productEntity.getStatus());
    }

}
