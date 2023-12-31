package emineozbek.organization.dto.requestDto;

import emineozbek.organization.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserUpdateRequestDto {

    private UUID id;

    private Status status;
}
