package com.davidticona.ent.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record UserDto(
        @NotNull
        Integer applicationId,
        
        @NotNull
        @NotEmpty
        String username, 
        
        @NotNull
        @NotEmpty
        String email,
        
        String pass,
        
        Boolean active) {

}
