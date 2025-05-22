package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	private boolean productExists(Long id) {
		return productRepository.findById(id).isEmpty();
	}

	public List<Product> getAllProducts() throws Exception {
		List<Product> products = productRepository.findAll();
		if (products.isEmpty()) {
			throw new Exception("Product not found");
		}
		return products;
	}

	public Product getProductById(Long id) throws Exception {
		return productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) throws Exception {
		if (productExists(product.getProductId())) {
			throw new Exception("Product doesn't exist");
		}
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
