package emineozbek.organization.dto.requestDto;

import emineozbek.organization.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {

    private final String fullName;

    private final String nickName;

    private final String email;

    private final Status status;
}
