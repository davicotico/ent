package com.davidticona.ent.domain.dto;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public record AdjacentItem(
        Integer id,
        Integer parentId,
        String code,
        String name) {

}
