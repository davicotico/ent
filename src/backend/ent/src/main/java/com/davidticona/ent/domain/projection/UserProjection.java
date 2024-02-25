package com.davidticona.ent.domain.projection;

import java.time.LocalDateTime;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface UserProjection {
    Integer getId();
    String getUsername();
    String getEmail();
    Boolean getIsValidEmail();
    LocalDateTime getCreatedAt();
}
