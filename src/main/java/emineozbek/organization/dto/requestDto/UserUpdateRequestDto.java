package emineozbek.organization.dto.requestDto;

import emineozbek.organization.model.Status;

public record UserUpdateRequestDto(Integer id, Status status) {

}
