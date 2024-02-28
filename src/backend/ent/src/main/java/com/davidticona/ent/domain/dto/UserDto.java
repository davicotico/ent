package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record UserDto(
        Integer applicationId,
        String username, 
        String email,
        String pass,
        Boolean active) {

}
