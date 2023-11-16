package emineozbek.organization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String fullName;

    private String nickName;

    private String email;

    private Status status;

    @ManyToMany(mappedBy = "users")
    private List<Invitation> invitations;

    @ManyToMany(mappedBy = "users")
    private List<Organization> organizations;

}
