package com.davidticona.ent.domain.dto.app;

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
