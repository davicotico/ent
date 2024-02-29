package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record RoleRequestDto(
        Integer applicationId,
        Integer parentId,
        String code,
        String name) {

}
