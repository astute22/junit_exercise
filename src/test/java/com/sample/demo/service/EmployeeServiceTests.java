package com.sample.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;
	
	@Ignore
	@Test
	public void testConfig() {
		assertNotNull(employeeService);
	}
	
	@Test
	public void testsimpleSearch() {
		Criteria c = new Criteria();
		c.setOpt("job");
		c.setKeyword("IT_PROG");
		List<Employee> result = employeeService.searchEmployees(c);
		
		assertEquals(5, result.size());	
	}
	
	@Test
	public void testExtendSearch() {
		List<String> jobs = Arrays.asList("AD_PRES", "AD_VP", "IT_PROG", "ST_CLERK");
		List<Integer> depts = Arrays.asList(50, 60, 80, 90);
		Long minSalary = (long) 10000;
		Long maxSalary = (long) 20000;
		
		Criteria c1 = new Criteria();
		c1.setJobs(jobs);
		List<Employee> result1 = employeeService.searchEmployees(c1);
		assertEquals(28, result1.size());	
		
		Criteria c2 = new Criteria();
		c2.setDepts(depts);
		List<Employee> result2 = employeeService.searchEmployees(c2);
		assertEquals(87, result2.size());	
		
		Criteria c3 = new Criteria();
		c3.setMinSalary(minSalary);
		c3.setMaxSalary(maxSalary);
		List<Employee> result3 = employeeService.searchEmployees(c3);
		assertEquals(18, result3.size());	
		
		Criteria c4 = new Criteria();
		c4.setBeginDate("2005-01-01");
		c4.setEndDate("2006-01-01");
		List<Employee> result4 = employeeService.searchEmployees(c4);
		assertEquals(29, result4.size());
	}
	
}
