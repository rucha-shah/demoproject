package com.training.demoproject.services.impl;

import com.training.demoproject.entity.Organization;
import com.training.demoproject.repository.OrganizationRepository;
import com.training.demoproject.services.OrganizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServicesImpl implements OrganizationServices {

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Organization save(Organization organization)
    {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAllOrganization()
    {
        List<Organization> list = new ArrayList<>();
        for (Organization organization : organizationRepository.findAll()) {
            list.add(organization);
        }
        return list;

    }

}
