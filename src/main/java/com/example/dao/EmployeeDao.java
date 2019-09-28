package com.example.dao;

import com.example.model.Employee;

public interface EmployeeDao {

	public Employee getById(String id);

	public Employee getByName(String Name);

}