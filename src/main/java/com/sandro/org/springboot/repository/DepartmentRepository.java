package com.sandro.org.springboot.repository;

import com.sandro.org.springboot.domain.Department;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer>,
        JpaSpecificationExecutor<Department> {

}