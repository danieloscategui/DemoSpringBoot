package com.dospe.demo.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dospe.demo.persistence.domain.Employee;
import com.dospe.demo.persistence.repository.EmployeeRepository;
import com.dospe.demo.transactional.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Collection<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
