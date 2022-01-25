package CandiFormation_Spring.SolutionChallenge.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {

  private String grantType;
  private String accessToken;
  private String refreshToken;
  private Long accessTokenExpiresIn;
}