package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	private static final class EmployeeMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getString("id"), rs.getString("name"),rs.getString("addressid"));
		}
		
	}

	@Override
	public Employee getById(String id) {
		return jdbc.queryForObject("select id,name, addressid from employee where id=:id", new EmployeeMapper(), id);
	}

	@Override
	public Employee getByName(String name) {
		return jdbc.queryForObject("select id,name, addressid from employee where name=?", this::mapRowToEmployee,
				name);
	}

	private Employee mapRowToEmployee(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(rs.getString("id"), rs.getString("name"), rs.getString("addressid"));
	}

}
