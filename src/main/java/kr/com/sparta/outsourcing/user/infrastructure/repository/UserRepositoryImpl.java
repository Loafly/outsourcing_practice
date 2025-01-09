package kr.com.sparta.outsourcing.user.infrastructure.repository;

import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import kr.com.sparta.outsourcing.user.business.domain.repository.UserRepository;
import kr.com.sparta.outsourcing.user.infrastructure.entity.User;
import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDomain save(String email, String password, String userRole) {
        User user = userJpaRepository.save(new User(email,
                password,
                UserRole.valueOf(userRole)));

        return new UserDomain(
                user.getId(),
                user.getEmail(),
                user.getUserRole()
        );
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }
}
