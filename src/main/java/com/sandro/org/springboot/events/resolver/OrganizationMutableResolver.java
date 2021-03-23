package com.sandro.org.springboot.events.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import com.sandro.org.springboot.domain.Organization;
import com.sandro.org.springboot.domain.OrganizationInput;
import com.sandro.org.springboot.repository.OrganizationRepository;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMutableResolver implements GraphQLMutationResolver {

    private final OrganizationRepository repository;
    private final KafkaTemplate<String, String> template;

    OrganizationMutableResolver(OrganizationRepository repository, KafkaTemplate<String, String> template) {
        this.repository = repository;
        this.template = template;
    }

    public Organization newOrganization(OrganizationInput organizationInput) {
        Organization newOrg = repository.save(new Organization(null, organizationInput.getName(), null, null));
        template.send("myTopic", newOrg.toString());

        return newOrg;
    }
}