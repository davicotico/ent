package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona
 */
public record AppRequestDto(
        String code,
        String name,
        String description,
        String url
        ) {

}
