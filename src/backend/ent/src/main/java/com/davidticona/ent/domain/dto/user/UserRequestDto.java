package com.davidticona.ent.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record UserRequestDto(
        
        @NotNull
        @NotEmpty
        String username, 
        
        @NotNull
        @NotEmpty
        @Email
        String email,
        
        String pass) {

}
