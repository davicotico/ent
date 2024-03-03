package com.davidticona.ent.domain.dto.app;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record AppRequestDto(
        @NotNull
        @Length(max = 10, message = "El código no puede ser mayor a 10 caracteres")
        String code,
        
        @NotNull(message = "El nombre de la aplicación no puede ser nulo")
        @Length(max = 20)
        String name,
        
        @NotNull
        @Length(max = 150)
        String description,
        
        @Length(max = 250)
        String url
        ) {

}
