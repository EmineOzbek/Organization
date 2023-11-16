package emineozbek.organization.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OrganizationRequestDto {

    private String organizationNameNumeric;

    private String organizationName;

    private Long registerNumber;

    private String email;

    private LocalDate foundedYear;

    private String phoneNumber;

    private int companySize;
}
