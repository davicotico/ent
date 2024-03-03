package com.davidticona.ent.domain.dto.permission;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record PermissionResponseDto(
        Integer id, 
        Integer parentId,
        Integer applicationId,
        String code,
        String name
        ) {

}
