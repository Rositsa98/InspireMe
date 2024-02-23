package com.art.me.inspire.store.service;

import com.art.me.inspire.store.model.NewProductProperties;
import com.art.me.inspire.store.model.ProductInfo;
import com.art.me.inspire.store.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    protected ProductRepo productRepo;

    public ProductInfo createProduct(NewProductProperties productProperties) {
        return productRepo.addProduct(productProperties);
    }
}
