package com.dospe.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
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

	@GetMapping("/page")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> paging(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		int page = request.getParameter("page") == null? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null? 10 : Integer.parseInt(request.getParameter("rows"));
		logger.info("page: " + page);
		logger.info("rows: " + rows);
		
//		List<Employee> employeeList = (List<Employee>) employeeService.findAll();
		
		Page<Employee> employeePage = employeeService.findAll(page, rows);
		
		logger.info("total elements: " + employeePage.getTotalElements());
		result.put("total", employeePage.getTotalElements());
		result.put("rows", employeePage.getContent().stream()
				.map(employee -> convertToDTO(employee))
				.collect(Collectors.toList()));
		
		return result;
	}
	
	private EmployeeListDTO convertToDTO(Employee employee) {
		return modelMapper.map(employee, EmployeeListDTO.class);
	}
}
