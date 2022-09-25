package com.mybootapp.dto;

public class ProductDto {
	private String name;
	private double price;
	private String vendorName;
	private String city;

	public ProductDto(String name, double price, String vendorName, String city) {
		super();
		this.name = name;
		this.price = price;
		this.vendorName = vendorName;
		this.city = city;
	}

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", price=" + price + ", vendorName=" + vendorName + ", city=" + city + "]";
	}

}
