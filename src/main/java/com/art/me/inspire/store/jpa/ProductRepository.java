package com.art.me.inspire.store.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

/**
 * Spring {@link JpaRepository} for querying {@link ProductEntity} in sql db.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, UUID>, JpaSpecificationExecutor<ProductEntity> {
}
