package emineozbek.organization.controller;

import emineozbek.organization.dto.requestDto.UserRequestDto;
import emineozbek.organization.dto.requestDto.UserUpdateRequestDto;
import emineozbek.organization.dto.responseDto.OrganizationResponseDto;
import emineozbek.organization.dto.responseDto.UserResponseDto;
import emineozbek.organization.model.Status;
import emineozbek.organization.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody final UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.saveUser(userRequestDto), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUserByEmail")
    public ResponseEntity<UserResponseDto> getUserByEmail(@RequestParam final String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/getUserByNickName")
    public ResponseEntity<UserResponseDto> getUserByNickName(@RequestParam final String nickName) {
        return new ResponseEntity<>(userService.getUserByNickName(nickName), HttpStatus.OK);
    }

    @GetMapping("/getUserByStatus")
    public ResponseEntity<List<UserResponseDto>> getUserByStatus(@RequestBody final Status status) {
        return new ResponseEntity<>(userService.getUserByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganizationsByUser")
    public ResponseEntity<List<OrganizationResponseDto>> getAllOrganizationsByUser(@RequestParam final UUID id){
        return new ResponseEntity<>(userService.getAllOrganizationsByUser(id), HttpStatus.OK);
    }

    @PutMapping("/updateUserStatus")
    public ResponseEntity<UserResponseDto> updateUserStatus(@RequestBody final UserUpdateRequestDto userUpdateRequestDto) {
        return new ResponseEntity<>(userService.updateUserStatus(userUpdateRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> deleteUserById(@RequestParam final UUID userId) {
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }
}
