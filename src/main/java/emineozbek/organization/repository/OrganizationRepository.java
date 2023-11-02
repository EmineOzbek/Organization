package emineozbek.organization.repository;

import emineozbek.organization.model.Organization;
import emineozbek.organization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {


    List<Organization> findByName(String organizationName);

    List<User> findAllUsersByOrganization(final String organizationNameNumeric);

    Organization findByRegisterNumber(final Long registerNumber);
}
