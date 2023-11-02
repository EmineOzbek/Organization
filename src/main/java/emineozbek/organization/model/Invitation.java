package emineozbek.organization.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
