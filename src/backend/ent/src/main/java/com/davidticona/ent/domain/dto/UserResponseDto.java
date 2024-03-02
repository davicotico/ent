package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona
 */
public record UserResponseDto(
        Integer id,
        String username, 
        String email,
        Boolean active
        ) {

}
