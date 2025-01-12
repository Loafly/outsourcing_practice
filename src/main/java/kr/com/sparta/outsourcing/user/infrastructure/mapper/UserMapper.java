package kr.com.sparta.outsourcing.user.infrastructure.mapper;

import kr.com.sparta.outsourcing.common.mapper.BaseMapper;
import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import kr.com.sparta.outsourcing.user.infrastructure.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<User, UserDomain> {
    public UserMapper(ModelMapper modelMapper) {
        super(modelMapper, User.class, UserDomain.class);
    }
}
