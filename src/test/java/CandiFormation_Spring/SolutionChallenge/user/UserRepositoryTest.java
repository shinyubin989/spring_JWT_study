package CandiFormation_Spring.SolutionChallenge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
  @Autowired
  private UserRepository userRepository;
}