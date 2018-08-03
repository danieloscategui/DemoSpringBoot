package com.dospe.demo.transactional.service;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.dospe.demo.persistence.domain.Employee;

public interface EmployeeService {
	public Collection<Employee> findAll();
	public Page<Employee> findAll(int page, int size);
}
