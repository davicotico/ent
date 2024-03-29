package com.davidticona.ent.domain.dto.role;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record RoleRequestDto(
        @NotNull(message = "ID de la aplicación es requerido")
        Integer applicationId,
        
        @NotNull(message = "parent id can not be null")
        Integer parentId,
        
        @NotNull(message = "Código del rol es requerido")
        @NotEmpty(message = "Código del rol no puede estar vacío")
        String code,
        
        @NotNull(message = "Nombre del rol es requerido")
        @NotEmpty(message = "Nompre del rol no puede estar vacío")
        String name) {

}
