package org.lojaroupas.api.service.impl;

import java.util.NoSuchElementException;

import org.lojaroupas.api.domain.model.Product;
import org.lojaroupas.api.domain.repository.ProductRepository;
import org.lojaroupas.api.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  
  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product findById(Long id) {
    return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Product register(Product productToRegister) {
    return productRepository.save(productToRegister); 
  }
}
