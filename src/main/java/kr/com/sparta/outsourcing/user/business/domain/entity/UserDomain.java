package kr.com.sparta.outsourcing.user.business.domain.entity;

import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private Long id;
    private String email;
    private String password;
    private UserRole userRole;
    private LocalDateTime deletedAt;

    public UserDomain(String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.deletedAt = null;
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }
}
