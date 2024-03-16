package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class AppUserId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "application_id")
    Integer applicationId;

    @Column(name = "user_id")
    Integer userId;

    public AppUserId(Integer applicationId, Integer userId) {
        this.applicationId = applicationId;
        this.userId = userId;
    }

    public AppUserId() {
    }
}
