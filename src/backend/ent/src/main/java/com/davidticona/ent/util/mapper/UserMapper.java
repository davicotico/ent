package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.user.UserRequestDto;
import com.davidticona.ent.domain.dto.user.UserResponseDto;
import com.davidticona.ent.domain.entity.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(UserRequestDto user);
    List<User> toEntity(List<UserRequestDto> user);
    
    UserResponseDto toDto(User user);
    List<UserResponseDto> toDto(List<User> user);
}
