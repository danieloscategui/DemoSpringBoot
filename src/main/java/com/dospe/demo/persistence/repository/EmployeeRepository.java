package com.dospe.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.demo.persistence.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
