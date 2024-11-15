package com.nimap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.entity.Product;
import com.nimap.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl psv;

//	GET all the products :
//	http://localhost:8080/api/products?page=2
	@GetMapping()
	public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		return psv.getAllProducts(page, size);
	}

//	POST - create a new product :
//	http://localhost:8080/api/products
	@PostMapping()
	public Product addCategory(@RequestBody Product product) {
		return psv.addProduct(product);

	}

//	GET product by Id :
//	http://localhost:8080/api/products/{di}
	@GetMapping("/{di}")
	public Product getProductById(@PathVariable int di) {
		return psv.getProductById(di);
	}

//	PUT - update product by id :
//	http://localhost:8080/api/products/{di}
	@PutMapping("/{di}")
	public Product updateProduct(@PathVariable int di, @RequestBody Product product) {
		return psv.updateProductById(di, product);
	}

//	DELETE - Delete product by id :
//	http://localhost:8080/api/products/{di}
	@DeleteMapping("/{di}")
	public String deleteProductByid(@PathVariable int di) {
		psv.deleteproduct(di);
		return "Product deleted";
	}
}
