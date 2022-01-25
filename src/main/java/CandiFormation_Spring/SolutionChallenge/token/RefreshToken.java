package CandiFormation_Spring.SolutionChallenge.token;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "refresh_token")
@Entity
public class RefreshToken {

  @Id
  private String key;
  private String value;

  public RefreshToken updateValue(String token) {
    this.value = token;
    return this;
  }

  @Builder
  public RefreshToken(String key, String value) {
    this.key = key;
    this.value = value;
  }
}
