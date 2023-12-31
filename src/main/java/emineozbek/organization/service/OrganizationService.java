package emineozbek.organization.service;

import emineozbek.organization.dto.requestDto.OrganizationRequestDto;

import emineozbek.organization.dto.responseDto.OrganizationResponseDto;
import emineozbek.organization.dto.responseDto.UserResponseDto;
import emineozbek.organization.model.Organization;
import emineozbek.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final  OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    public OrganizationResponseDto saveOrganization(final OrganizationRequestDto organizationRequestDto) {
        final Organization organization = modelMapper.map(organizationRequestDto, Organization.class);
        organizationRepository.save(organization);
        return modelMapper.map(organization, OrganizationResponseDto.class);
    }

    public List<OrganizationResponseDto> getOrganizationsByName(final String organizationName) {
        return organizationRepository.findByOrganizationName(organizationName)
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationResponseDto.class))
                .toList();
    }

    public List<OrganizationResponseDto> getOrganizationsByNameNumeric(final String organizationNameNumeric) {
        return organizationRepository.findByOrganizationName(organizationNameNumeric)
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationResponseDto.class))
                .toList();
    }

    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationResponseDto.class))
                .toList();
    }


    public List<UserResponseDto> getAllUsersByOrganization(final String organizationNameNumeric) {
        return organizationRepository.findAllUsersByOrganizationNameNumeric(organizationNameNumeric)
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class)).toList();
    }

    public OrganizationResponseDto getOrganizationByRegisterNumber(final Long registerNumber) {
        final Organization organization = organizationRepository.findByRegisterNumber(registerNumber);
        return modelMapper.map(organization, OrganizationResponseDto.class);
    }

}
