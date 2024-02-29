package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona
 */
public record AppResponseDto(
        Integer id,
        String code,
        String name,
        String description,
        String url
        ) {

}
