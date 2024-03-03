package com.davidticona.ent.domain.dto.role;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record RoleResponseDto(
        Integer id, 
        Integer parentId,
        Integer applicationId,
        String code,
        String name) {

}
