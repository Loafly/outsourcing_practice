package kr.com.sparta.outsourcing.user.business.domain.repository;

import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    UserDomain save(UserDomain userDomain);
    boolean existsByEmail(String email);

}
