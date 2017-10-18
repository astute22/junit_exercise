package com.sample.demo.service;

import java.util.List;

import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

public interface EmployeeService {
	List<Employee> searchEmployees(Criteria c);
}
