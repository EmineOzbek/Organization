package emineozbek.organization.controller;

import emineozbek.organization.dto.requestDto.OrganizationRequestDto;
import emineozbek.organization.dto.responseDto.OrganizationResponseDto;
import emineozbek.organization.dto.responseDto.UserResponseDto;
import emineozbek.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizatitonController {

    private final OrganizationService organizationService;

    @PostMapping("/saveOrganization")
    public ResponseEntity<OrganizationResponseDto> saveUser(@RequestBody final OrganizationRequestDto organizationRequestDto) {
        return new ResponseEntity<>(organizationService.saveOrganization(organizationRequestDto), HttpStatus.OK);
    }

    @GetMapping("/getUsersByOrganization")
    public ResponseEntity<List<UserResponseDto>> getAllUsersByOrganization(@RequestParam final String organizationNameNumeric) {
        return new ResponseEntity<>(organizationService.getAllUsersByOrganization(organizationNameNumeric), HttpStatus.OK);
    }

    @GetMapping("/getOrganizationsByName")
    public ResponseEntity<List<OrganizationResponseDto>> getOrganizationsByName(@RequestParam final String organizationName) {
        return new ResponseEntity<>(organizationService.getOrganizationsByName(organizationName), HttpStatus.OK);
    }

    @GetMapping("/getOrganizationsByNameNumeric")
    public ResponseEntity<List<OrganizationResponseDto>> getOrganizationsByNameNumeric(@RequestParam final String organizationNameNumeric) {
        return new ResponseEntity<>(organizationService.getOrganizationsByNameNumeric(organizationNameNumeric), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganizations")
    public ResponseEntity<List<OrganizationResponseDto>> getAllOrganizations() {
        return new ResponseEntity<>(organizationService.getAllOrganizations(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<OrganizationResponseDto> getOrganizationByRegisterNumber(@RequestParam final Long registerNumber) {
        return new ResponseEntity<>(organizationService.getOrganizationByRegisterNumber(registerNumber), HttpStatus.OK);
    }

}
