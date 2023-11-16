package emineozbek.organization.controller;

import emineozbek.organization.dto.requestDto.InvitationRequestDto;
import emineozbek.organization.dto.responseDto.InvitationResponseDto;
import emineozbek.organization.service.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invitations")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @PostMapping("saveInvitation")
    public ResponseEntity<InvitationResponseDto> saveInvitation(@RequestBody final InvitationRequestDto invitationRequestDto) {
        return new ResponseEntity<>(invitationService.saveInvitation(invitationRequestDto), HttpStatus.OK);
    }
}
