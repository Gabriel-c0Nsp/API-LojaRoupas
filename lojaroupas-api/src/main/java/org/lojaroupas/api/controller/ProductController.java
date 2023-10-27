package org.lojaroupas.api.controller;

import org.lojaroupas.api.domain.model.Product;
import org.lojaroupas.api.domain.repository.ProductRepository;
import org.lojaroupas.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;
  
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    var product = productService.findById(id);
    if (product != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(product);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PostMapping
  public ResponseEntity<Product> register(@RequestBody Product productToRegister) {
    var productCreated = productService.register(productToRegister);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(productCreated.getId())
      .toUri();
    return ResponseEntity.created(location).body(productCreated);
  }

}
