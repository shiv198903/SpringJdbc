package com.example.model;

public class Employee {

	private String id;
	private String name;
	private String addressId;

	public Employee(String id, String name, String addressId) {
		super();
		this.id = id;
		this.name = name;
		this.addressId = addressId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", addressId=" + addressId + "]";
	}

}
