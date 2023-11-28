package org.lojaroupas.api.service;

import java.util.List;

import org.lojaroupas.api.domain.model.Product;

public interface ProductService {

  Product findById(Long id);

  Product register(Product productToRegister);

  Iterable<Product> registerAll(Iterable<Product> productListToSave);

  void removeById(Long id);

  public List<Product> findAll();

  Product updateProduct(Long id, Product productToUpdate);
}
