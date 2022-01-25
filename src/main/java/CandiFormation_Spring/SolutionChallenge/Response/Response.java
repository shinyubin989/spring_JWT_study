package CandiFormation_Spring.SolutionChallenge.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

  private int status;
  private boolean success = true;
  private String message;

  public Response(int status, boolean success, String message) {
    this.status = status;
    this.success = success;
    this.message = message;
  }
}
