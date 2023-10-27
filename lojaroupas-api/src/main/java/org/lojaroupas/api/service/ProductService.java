package org.lojaroupas.api.service;

import org.lojaroupas.api.domain.model.Product;

public interface ProductService {

  Product findById(Long id);
  
  Product register(Product productToRegister);

}
