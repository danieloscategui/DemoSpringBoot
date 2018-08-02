package com.dospe.demo.transactional.service;

import java.util.Collection;

import com.dospe.demo.persistence.domain.Employee;

public interface EmployeeService {
	public Collection<Employee> findAll();
}
