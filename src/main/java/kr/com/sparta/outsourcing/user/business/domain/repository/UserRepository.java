package kr.com.sparta.outsourcing.user.business.domain.repository;

import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    UserDomain save(String email, String password, String userRole);

    boolean existsByEmail(String email);
}
