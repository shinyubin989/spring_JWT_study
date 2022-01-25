package CandiFormation_Spring.SolutionChallenge.dto;

import lombok.*;


public class UserDto {

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Request {
    private String email;
    private String password;
    private String nickname;
    private String tel;
  }

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Response {
    private String email;
    private String nickname;
    private String tel;
  }


//  public static class Response {
//    private String userId;
//    private String email;
//    private String name;
//    private String nickname;
//    private Boolean isAuth;
//  }




//
//  //회원가입
//  private String email;
//  private String password;
//  private String nickname;
//  private String tel;
//  private int status;
//  private boolean isSuccess;
//  private String message;



}
