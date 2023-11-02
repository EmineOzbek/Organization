package emineozbek.organization.service;

import emineozbek.organization.dto.requestDto.UserRequestDto;
import emineozbek.organization.dto.requestDto.UserUpdateRequestDto;
import emineozbek.organization.dto.responseDto.OrganizationResponseDto;
import emineozbek.organization.dto.responseDto.UserResponseDto;
import emineozbek.organization.model.Status;
import emineozbek.organization.model.User;
import emineozbek.organization.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserResponseDto saveUser(final UserRequestDto userRequestDto) {
        final User user = modelMapper.map(userRequestDto, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .toList();
    }

    public UserResponseDto getUserByEmail(final String email) {
        final User user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getUserByNickName(final String nickName) {
        final User user = userRepository.findByNickName(nickName);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public List<UserResponseDto> getUserByStatus(final Status status) {
        return userRepository.findByStatus(status)
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .toList();
    }

    public List<OrganizationResponseDto> getAllOrganizationsByUser(final UUID id) {
        return userRepository.findAllOrganizationsByUser(id)
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationResponseDto.class))
                .toList();
    }

    public UserResponseDto updateUserStatus(final UserUpdateRequestDto userUpdateRequestDto) {
        final User user = userRepository.findById(userUpdateRequestDto.id()).orElseThrow();
        user.setStatus(userUpdateRequestDto.status());
        return modelMapper.map(userRepository.save(user), UserResponseDto.class);
    }

    public String deleteUserById(final Integer userId) {
        userRepository.deleteById(userId);
        return String.format("%s Id'li kullanıcı silindi!", userId);
    }
}
