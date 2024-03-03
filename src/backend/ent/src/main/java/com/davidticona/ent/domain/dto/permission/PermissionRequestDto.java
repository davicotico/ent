package com.davidticona.ent.domain.dto.permission;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record PermissionRequestDto(
        @NotNull
        Integer applicationId,
        
        Integer parentId,
        
        @NotNull
        @NotEmpty
        String code,
        
        @NotNull
        @NotEmpty
        String name) {

}
