package emineozbek.organization.dto.responseDto;

import emineozbek.organization.model.Status;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserResponseDto {

    private final String fullName;

    private final Status status;

}
