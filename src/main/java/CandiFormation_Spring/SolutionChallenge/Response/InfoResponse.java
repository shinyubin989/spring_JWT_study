package CandiFormation_Spring.SolutionChallenge.Response;

import CandiFormation_Spring.SolutionChallenge.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoResponse {

  private String email;
  private String nickname;

  public InfoResponse(String email, String nickname) {
    this.email = email;
    this.nickname = nickname;
  }

}
