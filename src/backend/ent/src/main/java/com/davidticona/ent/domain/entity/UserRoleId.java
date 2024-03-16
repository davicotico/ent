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
public class UserRoleId implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "user_id")
    Integer userId;
    
    @Column(name = "role_id")
    Integer roleId;

    public UserRoleId(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRoleId() {
    }
    
    
}
