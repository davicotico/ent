package com.davidticona.ent.domain.projection;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface AdjacentItemProjection {
    Integer getId();
    Integer getParentId();
    String getCode();
    String getName();
    Boolean getIsRoot();
}
