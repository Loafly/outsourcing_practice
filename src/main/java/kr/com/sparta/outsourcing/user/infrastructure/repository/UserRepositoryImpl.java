package kr.com.sparta.outsourcing.user.infrastructure.repository;

import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import kr.com.sparta.outsourcing.user.business.domain.repository.UserRepository;
import kr.com.sparta.outsourcing.user.infrastructure.entity.User;
import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import kr.com.sparta.outsourcing.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<UserDomain> findById(Long id) {
        return userJpaRepository.findById(id)
                .map(userMapper::toDomain);

    }

    @Override
    public Optional<UserDomain> findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }

    @Override
    public UserDomain save(String email, String password, UserRole userRole) {
        User user = userJpaRepository.save(
                new User(
                        email,
                        password,
                        userRole
                )
        );

        return userMapper.toDomain(user);
    }

    public UserDomain save(UserDomain userDomain) {
        User savedUser = userJpaRepository.save(userMapper.toEntity(userDomain));

        return userMapper.toDomain(savedUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }
}
