package com.sandro.org.springboot.events.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import com.sandro.org.springboot.domain.Department;
import com.sandro.org.springboot.domain.DepartmentInput;
import com.sandro.org.springboot.domain.Organization;
import com.sandro.org.springboot.repository.DepartmentRepository;
import com.sandro.org.springboot.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class DepartmentMutableResolver implements GraphQLMutationResolver {

    DepartmentRepository departmentRepository;
    OrganizationRepository organizationRepository;

    DepartmentMutableResolver(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.organizationRepository = organizationRepository;
    }

    public Department newDepartment(DepartmentInput departmentInput) {
        Organization organization = organizationRepository.findById(departmentInput.getOrganizationId()).get();
        System.out.println(organization.getName());
        return departmentRepository.save(new Department(null, departmentInput.getName(), null, organization));
    }

}