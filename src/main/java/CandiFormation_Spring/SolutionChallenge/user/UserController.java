package CandiFormation_Spring.SolutionChallenge.user;


import CandiFormation_Spring.SolutionChallenge.Response.Response;
import CandiFormation_Spring.SolutionChallenge.dto.UserDto;
import CandiFormation_Spring.SolutionChallenge.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/me")
  public ResponseEntity<UserResponseDto> getMyInfo() {
    return ResponseEntity.ok(userService.getMyInfo());
  }

  @GetMapping("/{email}")
  public ResponseEntity<UserResponseDto> getMemberInfo(@PathVariable String email) {
    return ResponseEntity.ok(userService.getUserInfo(email));
  }
/*
  @GetMapping("")
  public Response myPage() {

  }

 */
}
