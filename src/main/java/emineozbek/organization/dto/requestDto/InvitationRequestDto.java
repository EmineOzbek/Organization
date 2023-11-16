package emineozbek.organization.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class InvitationRequestDto {

    private String invitationMessage;

    private UUID userId;

    private UUID organizationId;

}
