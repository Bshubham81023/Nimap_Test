package com.nimap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entity.Product;
import com.nimap.repository.ProductRepository;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepository prepo;

	public Page<Product> getAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return prepo.findAll(pageable);
	}
	
	public Product addProduct(Product product) {
		return prepo.save(product);
	}

	public Product getProductById(int id) {
		return prepo.findById(id).orElse(null);
	}

	public Product updateProductById(int id, Product product) {
		@SuppressWarnings("deprecation")
		Product products = prepo.getById(id);
		products.setP_name(product.getP_name());
		products.setP_desp(product.getP_desp());
		products.setCategory(product.getCategory());
		return prepo.save(products);
	}

	public void deleteproduct(int id) {
		Product product = prepo.getById(id);
		prepo.delete(product);
	}

	

}
