package emineozbek.organization.dto.responseDto;

import emineozbek.organization.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private String fullName;

    private Status status;

}
