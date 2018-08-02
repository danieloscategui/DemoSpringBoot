package com.dospe.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dospe.demo.controller.dto.EmployeeListDTO;
import com.dospe.demo.persistence.domain.Employee;
import com.dospe.demo.transactional.service.EmployeeService;

@RestController
@RequestMapping("employee/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<EmployeeListDTO> getAll(){
		List<Employee> employeeList = (List<Employee>) employeeService.findAll();
		return employeeList.stream()
				.map(employee -> convertToDTO(employee))
				.collect(Collectors.toList());
		
	}
	
	private EmployeeListDTO convertToDTO(Employee employee) {
		return modelMapper.map(employee, EmployeeListDTO.class);
	}
}
