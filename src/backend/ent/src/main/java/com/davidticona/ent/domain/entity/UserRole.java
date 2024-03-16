package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Entity
@Getter
@Setter
@Table(name = "user_role", schema = "ent")
public class UserRole {
    
    @EmbeddedId
    UserRoleId id;
    
    @ManyToOne
    @MapsId("userId")
    User user;
    
    @ManyToOne
    @MapsId("roleId")
    Role role;
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    
}
