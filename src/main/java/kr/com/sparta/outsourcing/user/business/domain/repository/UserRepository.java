package kr.com.sparta.outsourcing.user.business.domain.repository;

import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {

    Optional<UserDomain> findById(Long id);
    Optional<UserDomain> findByEmail(String email);
    UserDomain save(String email, String password, UserRole userRole);
    UserDomain save(UserDomain userDomain);
    boolean existsByEmail(String email);
}
