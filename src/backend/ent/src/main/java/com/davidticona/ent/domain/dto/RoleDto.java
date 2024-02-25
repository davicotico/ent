package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona
 */
public record RoleDto(
        Integer id, 
        Integer parentId,
        String code,
        String name) {

}
