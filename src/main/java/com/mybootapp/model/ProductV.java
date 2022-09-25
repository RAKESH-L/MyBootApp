package com.mybootapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductV {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double price;
	
	@ManyToOne
	private Vendor vendor;

	public ProductV(int id, String name, double price, Vendor vendor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vendor = vendor;
	}

	public ProductV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "ProductV [id=" + id + ", name=" + name + ", price=" + price + ", vendor=" + vendor + "]";
	}
	
	
}
