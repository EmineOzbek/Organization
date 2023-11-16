package emineozbek.organization.dto.responseDto;

import emineozbek.organization.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InvitationResponseDto {

    private Status status;

    private String invitationMessage;

    private String organizationName;
}
