package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.AddressDao;
import com.example.dao.EmployeeDao;
import com.example.model.Address;
import com.example.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJdbcApplicationTests {
	@Autowired
	ApplicationContext appCtxt;
	@Autowired
	AddressDao adao;
	@Autowired
	EmployeeDao edao;

	@Test
	public void contextLoads() {
		DataSource ds = appCtxt.getBean("dataSource", DataSource.class);
		assertNotNull(ds);
	}

	@Test
	public void testepositoryBeans() {
		AddressDao adao = appCtxt.getBean(AddressDao.class);
		EmployeeDao edao = appCtxt.getBean(EmployeeDao.class);
		assertNotNull(adao);
		assertNotNull(edao);
	}

	@Test
	public void testEmployeeData() {
		Employee employee = edao.getByName("One");
		assertNotNull(employee);
		assertEquals("1", employee.getId());
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void testInvalidEmployeeData() {
		edao.getByName("Oneee");
	}

	@Test
	public void testAddressData() {
		Address address = adao.findByCity("Hyderabad");
		assertNotNull(address);
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void testInvalidAddressData() {
		adao.findByCity("Hyderabaddd");
	}

}
