package com.example.dao;

import com.example.model.Address;

public interface AddressDao {

	public Address findByCity(String city);

	public Address findById(String id);

	//public Iterable<Address> findByCountry(String country);

}
