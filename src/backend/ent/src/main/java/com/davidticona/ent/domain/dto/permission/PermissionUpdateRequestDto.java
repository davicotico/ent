package com.davidticona.ent.domain.dto.permission;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record PermissionUpdateRequestDto(
        @NotNull(message = "Código del rol es requerido")
        @NotEmpty(message = "Código del rol no puede estar vacío")
        @Length(max = 20)
        String code,
        
        @NotNull(message = "Nombre del rol es requerido")
        @NotEmpty(message = "Nompre del rol no puede estar vacío")
        @Length(max = 50)
        String name
        ) {

}
