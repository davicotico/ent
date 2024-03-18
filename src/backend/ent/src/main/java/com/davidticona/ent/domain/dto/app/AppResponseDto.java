package com.davidticona.ent.domain.dto.app;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record AppResponseDto(
        Integer id,
        String code,
        String name,
        String description,
        String url,
        String version
        ) {

}
