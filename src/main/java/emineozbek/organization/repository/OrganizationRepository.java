package emineozbek.organization.repository;

import emineozbek.organization.model.Organization;
import emineozbek.organization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {


    List<Organization> findByOrganizationName(String organizationName);

    List<User> findAllUsersByOrganizationNameNumeric(final String organizationNameNumeric);

    Organization findByRegisterNumber(final Long registerNumber);
}
