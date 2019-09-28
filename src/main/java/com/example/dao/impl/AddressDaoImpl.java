package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.dao.AddressDao;
import com.example.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private JdbcTemplate jdbc;

	private static final class AddressMapper implements RowMapper<Address> {

		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Address(rs.getString("id"), rs.getString("city"), rs.getString("country"));
		}

	}

	@Override
	public Address findByCity(String city) {
		return jdbc.queryForObject("select id,city, country from address where city=?", new AddressMapper(), city);
	}

	@Override
	public Address findById(String id) {
		return jdbc.queryForObject("select id,city, country from address where id=?", this::mapRowToAddress, id);
	}

	/*
	 * @Override public Iterable<Address> findByCountry(String country) { return
	 * jdbc.query("select id,city, country from address where country=?",
	 * country,this::mapRowToAddress);
	 * 
	 * }
	 */

	private Address mapRowToAddress(ResultSet rs, int rowNum) throws SQLException {
		return new Address(rs.getString("id"), rs.getString("city"), rs.getString("country"));
	}

}
