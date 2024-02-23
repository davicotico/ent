package com.davidticona.ent.domain.projection;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface AdjacentPermission {
    Integer getId();
    Integer parentId();
    String getCode();
    Boolean getIsRoot();
}
