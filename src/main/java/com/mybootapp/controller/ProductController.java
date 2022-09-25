package com.mybootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.dto.ProductDto;
import com.mybootapp.model.Product;
import com.mybootapp.model.ProductV;
import com.mybootapp.model.Vendor;
import com.mybootapp.repository.ProductRepository;
import com.mybootapp.repository.ProductVRepository;
import com.mybootapp.repository.VendorRepository;

@RestController
public class ProductController { 
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public VendorRepository vendorRepository;
	
	@Autowired
	public ProductVRepository producyVRepository;
	
	@PostMapping("/product/insert")
	public Product insertProduct(@RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	@GetMapping("/product/all")
	public List<Product> getAllProduct() {
		List<Product> list = productRepository.findAll();
		return list;
	}
	
	@PostMapping("/product/insert1")
	public ProductV insert1Product(@RequestBody ProductDto productDto) {
		ProductV product = new ProductV();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		
		Vendor vendor = new Vendor();
		vendor.setName(productDto.getVendorName());
		vendor.setCity(productDto.getCity());
		
		Vendor vendorDB = vendorRepository.findByName(vendor.getName());
		if(vendorDB == null) {
			vendor = vendorRepository.save(vendor);
		}
		else {
			vendor = vendorDB;
		}
		product.setVendor(vendor);
		
		return producyVRepository.save(product);
	}
}
