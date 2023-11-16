package emineozbek.organization.service;

import emineozbek.organization.dto.requestDto.InvitationRequestDto;
import emineozbek.organization.dto.responseDto.InvitationResponseDto;
import emineozbek.organization.model.Invitation;
import emineozbek.organization.model.Status;
import emineozbek.organization.model.User;
import emineozbek.organization.repository.InvitationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final InvitationRepository invitationRepository;


    public InvitationResponseDto saveInvitation(final InvitationRequestDto invitationRequestDto) {
        final Invitation invitation = modelMapper.map(invitationRequestDto, Invitation.class);
        invitation.setUsers(this.getUsersToInvited(invitation));
        invitation.setStatus(Status.PENDING);
        invitationRepository.save(invitation);
        return modelMapper.map(invitation, InvitationResponseDto.class);
    }

    private List<User> getUsersToInvited(final Invitation invitation) {
        final Status status = invitation.getStatus();
        return invitation.getUsers().stream().filter(user -> !Objects.equals(status, Status.PENDING)).toList();
    }
}
