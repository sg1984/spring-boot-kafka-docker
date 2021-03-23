package com.sandro.org.springboot.events.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import com.sandro.org.springboot.domain.Organization;
import com.sandro.org.springboot.repository.OrganizationRepository;

import org.springframework.stereotype.Component;

@Component
public class OrganizationQueryResolver implements GraphQLQueryResolver {

    private OrganizationRepository repository;

    OrganizationQueryResolver(OrganizationRepository repository) {
        this.repository = repository;
    }

    public Iterable<Organization> organizations() {
        return repository.findAll();
    }

    public Organization organization(Integer id) {
        return repository.findById(id).get();
    }
}