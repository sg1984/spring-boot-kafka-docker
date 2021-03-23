package com.sandro.org.springboot.repository;

import com.sandro.org.springboot.domain.Employee;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {
}