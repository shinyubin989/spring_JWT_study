package CandiFormation_Spring.SolutionChallenge.user;

import CandiFormation_Spring.SolutionChallenge.Response.InfoResponse;
import CandiFormation_Spring.SolutionChallenge.Response.Response;
import CandiFormation_Spring.SolutionChallenge.dto.UserDto;
import CandiFormation_Spring.SolutionChallenge.dto.UserResponseDto;
import CandiFormation_Spring.SolutionChallenge.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final ModelMapper modelMapper;

  @Transactional
  public UserResponseDto getUserInfo(String email) {
    return userRepository.findByEmail(email)
      .map(UserResponseDto::of)
      .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
  }

  // 현재 SecurityContext 에 있는 유저 정보 가져오기
  @Transactional
  public UserResponseDto getMyInfo() {
    return userRepository.findById((int) SecurityUtil.getCurrentMemberId())
      .map(UserResponseDto::of)
      .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
  }

//  @Transactional
//  public String Signup(UserDto.Request user){
//    if(userRepository.existsByEmail(user.getEmail())){
//      return "중복된 이메일입니다.";
//    }
//    if(userRepository.existsUserByNickname(user.getNickname())){
//      return "중복된 닉네임입니다.";
//    }
//    if(userRepository.existsUserByTel(user.getTel())){
//      return "중복된 전화번호입니다.";
//    }
//    User newUser = modelMapper.map(user, User.class);
//    String encodePassword = passwordEncoder.encode(user.getPassword());
//
//    newUser.setPassword(encodePassword);
//    userRepository.save(newUser);
//    return "회원가입 성공";
//  }

//  @Transactional()
//  public InfoResponse getUserInfo(String email) {
//    return userRepository.findByEmail(email)
//      .map(InfoResponse::of)
//      .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
//  }











}
