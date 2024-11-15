package com.nimap.service;

import org.springframework.data.domain.Page;

import com.nimap.entity.Product;

public interface ProductService {
	
	public Page<Product> getAllProducts(int page, int size);
	
	public Product addProduct(Product product);

	public Product getProductById(int id);

	public Product updateProductById(int id, Product product);	

	public void deleteproduct(int id);

}
