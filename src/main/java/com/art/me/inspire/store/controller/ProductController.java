package com.art.me.inspire.store.controller;

import com.art.me.inspire.store.model.NewProductProperties;
import com.art.me.inspire.store.model.ProductInfo;
import com.art.me.inspire.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.art.me.inspire.store.controller.Constants.ART_PRODUCT;

/**
 * Defines APIs related to products interactions.
 */
@RestController
public class ProductController {

   @Autowired
   protected ProductService productService;

   @PostMapping(value = ART_PRODUCT, consumes = {"application/json"})
   public ProductInfo createProduct(@RequestBody NewProductProperties productProperties) {
      return productService.createProduct(productProperties);
   }

}
