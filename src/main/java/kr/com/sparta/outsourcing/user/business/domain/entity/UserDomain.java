package kr.com.sparta.outsourcing.user.business.domain.entity;

import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDomain {
    private Long id;
    private String email;
    private UserRole userRole;

    public UserDomain(Long id, String email, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.userRole = userRole;
    }
}
