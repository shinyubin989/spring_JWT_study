package CandiFormation_Spring.SolutionChallenge.auth;

import CandiFormation_Spring.SolutionChallenge.dto.TokenDto;
import CandiFormation_Spring.SolutionChallenge.dto.TokenRequestDto;
import CandiFormation_Spring.SolutionChallenge.dto.UserRequestDto;
import CandiFormation_Spring.SolutionChallenge.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/signup")
  public ResponseEntity<UserResponseDto> signup(@RequestBody UserRequestDto userRequestDto) {
    return ResponseEntity.ok(authService.signup(userRequestDto));
  }

  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody UserRequestDto userRequestDto) {
    return ResponseEntity.ok(authService.login(userRequestDto));
  }

  @PostMapping("/reissue")
  public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
    return ResponseEntity.ok(authService.reissue(tokenRequestDto));
  }
}