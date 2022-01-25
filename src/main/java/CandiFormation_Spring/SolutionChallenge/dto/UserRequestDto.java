package CandiFormation_Spring.SolutionChallenge.dto;

import CandiFormation_Spring.SolutionChallenge.user.Authority;
import CandiFormation_Spring.SolutionChallenge.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

  private String email;
  private String password;

  public User toUser(PasswordEncoder passwordEncoder) {
    return User.builder()
      .email(email)
      .password(passwordEncoder.encode(password))
      .authority(Authority.ROLE_USER)
      .build();
  }

  public UsernamePasswordAuthenticationToken toAuthentication() {
    return new UsernamePasswordAuthenticationToken(email, password);
  }
}
