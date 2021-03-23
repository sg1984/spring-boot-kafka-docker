package com.sandro.org.springboot.events.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import com.sandro.org.springboot.domain.Employee;
import com.sandro.org.springboot.repository.EmployeeRepository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    private final EmployeeRepository repository;

    EmployeeQueryResolver(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Employee> employees() {
        return repository.findAll();
    }

    public Employee employee(Integer id) {
        return repository.findById(id).get();
    }
}