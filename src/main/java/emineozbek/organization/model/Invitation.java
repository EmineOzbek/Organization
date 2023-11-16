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
public class Invitation {

    @Id
    @GeneratedValue
    private UUID id;

    private String invitationMessage;

    private Status status;

    @OneToOne
    @JoinColumn(name="organization_id")
    private Organization organization;

    @ManyToMany
    @JoinTable(name = "user_invitation",
            joinColumns = @JoinColumn(name = "invitation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
