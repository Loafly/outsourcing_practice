package kr.com.sparta.outsourcing.user.infrastructure.repository;

import kr.com.sparta.outsourcing.user.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
}
