package Candiformation.spring.service;

import java.util.Collections;

import Candiformation.spring.entity.Authority;
import Candiformation.spring.entity.User;
import Candiformation.spring.exception.DuplicateMemberException;
import Candiformation.spring.repository.UserRepository;
import Candiformation.spring.dto.UserDto;
import Candiformation.spring.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public boolean signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new DuplicateMemberException("중복된 이메일입니다.");
        } else if (userRepository.findOneWithAuthoritiesByNickname(userDto.getNickname()).orElse(null) != null) {
            throw new DuplicateMemberException("중복된 닉네임입니다.");
        } else if (userRepository.findOneWithAuthoritiesByTel(userDto.getTel()).orElse(null) != null) {
            throw new DuplicateMemberException("중복된 전화번호입니다.");
        }
        /*
            {
                "status": 409,
                "message": "이미 가입되어 있는 유저입니다."
                "success" : false
    }       }
         */

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .tel(userDto.getTel())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        userRepository.save(user);

        return true;
    }

    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String username) {
        return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElse(null));
    }
}
