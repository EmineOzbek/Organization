package emineozbek.organization.repository;

import emineozbek.organization.model.Organization;
import emineozbek.organization.model.Status;
import emineozbek.organization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(final String email);

    User findByNickName(String nickName);

    List<User> findByStatus(Status status);

    List<Organization> findAllOrganizationsByUser(final UUID id);
}
