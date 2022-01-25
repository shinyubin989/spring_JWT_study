package CandiFormation_Spring.SolutionChallenge.user;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity //데이터베이스의 테이블과 1:1 매핑되는 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
  @Id
  @Column(nullable = false, name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Enumerated(EnumType.STRING)
  private Authority authority;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String tel;

  @Column(nullable = false)
  private String nickname;

  @Builder
  public User(String email,
              String password,
              Authority authority,
              String tel,
              String nickname) {
    this.email = email;
    this.password = password;
    this.authority = authority;
    this.tel = tel;
    this.nickname = nickname;
  }

}

