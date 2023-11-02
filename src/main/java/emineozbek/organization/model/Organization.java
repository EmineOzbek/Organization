package emineozbek.organization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Organization {

    @Id
    @GeneratedValue
    private UUID id;

    private String organizationNameNumeric;

    private String organizationName;

    private Long registerNumber;

    private String email;

    private Date foundedYear;

    private String phoneNumber;

    private int companySize;

    @ManyToMany
    @JoinTable(name = "user_organization",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

}
