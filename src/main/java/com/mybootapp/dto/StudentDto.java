package com.mybootapp.dto;

public class StudentDto {
	private String name;
	private String email;
	private String houseno;
	private String pincode;
	private String city;

	public StudentDto(String name, String email, String houseno, String pincode, String city) {
		super();
		this.name = name;
		this.email = email;
		this.houseno = houseno;
		this.pincode = pincode;
		this.city = city;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", email=" + email + ", houseno=" + houseno + ", pincode=" + pincode
				+ ", city=" + city + "]";
	}

}
