package emineozbek.organization.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    ACTIVE(false), PENDING(false), DEACTIVATED(false), INVITED(false),
    PASSIVE(false), DELETED(false), ACCEPTED(false), REJECTED(false);

    private final boolean isActive;

}
