package org.lojaroupas.api.service.impl;

import java.util.NoSuchElementException;
import org.lojaroupas.api.domain.model.Product;

import java.util.List;

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

  @Override
  public Iterable<Product> registerAll(Iterable<Product> productListToSave) {
    return productRepository.saveAll(productListToSave);
  }

  @Override
  public void removeById(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Product updateProduct(Long id, Product productToUpdate) {
    Product dbProduct = this.findById(id);
    if (!dbProduct.getId().equals(productToUpdate.getId())) {
      throw new NoSuchElementException();
    } else {
      dbProduct.setId(id);
      dbProduct.setImage(productToUpdate.getImage());
      dbProduct.setTitle(productToUpdate.getTitle());
      dbProduct.setPrice(productToUpdate.getPrice());
      dbProduct.setDescription(productToUpdate.getDescription());
      dbProduct.setCategory(productToUpdate.getCategory());

      return this.productRepository.save(dbProduct);
    }
  }

}
