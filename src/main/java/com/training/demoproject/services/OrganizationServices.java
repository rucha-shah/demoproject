package com.training.demoproject.services;

import com.training.demoproject.entity.Organization;

import java.util.List;

public interface OrganizationServices {
    Organization save(Organization organization);
    List<Organization> getAllOrganization();
}
