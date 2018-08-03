package com.dospe.demo.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.demo.persistence.domain.Employee;
import com.dospe.demo.persistence.repository.EmployeeRepository;
import com.dospe.demo.transactional.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Employee> findAll(int page, int size) {
		return  employeeRepository.findAll(new PageRequest(page, size));
	}

}
