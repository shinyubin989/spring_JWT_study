package CandiFormation_Spring.SolutionChallenge.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
  boolean existsByEmail(String email);

  boolean existsUserByNickname(String nickname);

  boolean existsUserByTel(String tel);

  @EntityGraph(attributePaths = "authorities")
  Optional<User> findOneWithAuthoritiesByEmail(String email);

}
