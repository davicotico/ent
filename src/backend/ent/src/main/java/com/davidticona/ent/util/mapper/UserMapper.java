package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.UserDto;
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
    User toEntity(UserDto user);
    List<User> toEntity(List<UserDto> user);
    
    UserDto toDto(User user);
    List<UserDto> toDto(List<User> user);
}
