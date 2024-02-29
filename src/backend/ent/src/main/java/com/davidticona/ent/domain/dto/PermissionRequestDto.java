package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record PermissionRequestDto(
        Integer applicationId,
        Integer parentId,
        String code,
        String name) {

}
