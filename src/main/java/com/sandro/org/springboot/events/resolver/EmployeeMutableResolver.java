package com.sandro.org.springboot.events.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import com.sandro.org.springboot.domain.Department;
import com.sandro.org.springboot.domain.Employee;
import com.sandro.org.springboot.domain.EmployeeInput;
import com.sandro.org.springboot.domain.Organization;
import com.sandro.org.springboot.repository.DepartmentRepository;
import com.sandro.org.springboot.repository.EmployeeRepository;
import com.sandro.org.springboot.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMutableResolver implements GraphQLMutationResolver {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;
    OrganizationRepository organizationRepository;

    EmployeeMutableResolver(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.organizationRepository = organizationRepository;
    }

    public Employee newEmployee(EmployeeInput employeeInput) {
        Department department = departmentRepository.findById(employeeInput.getDepartmentId()).get();
        Organization organization = organizationRepository.findById(employeeInput.getOrganizationId()).get();
        return employeeRepository.save(new Employee(null, employeeInput.getFirstName(), employeeInput.getLastName(),
                employeeInput.getPosition(), employeeInput.getAge(), employeeInput.getSalary(),
                department, organization));
    }

}
