package com.davidticona.ent.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="role_permission", schema = "ent")
public class RolePermission {
    
    @EmbeddedId
    private RolePermissionId id;
    
    @ManyToOne
    @MapsId("roleId")
    private Role role;
    
    @ManyToOne
    @MapsId("permissionId")
    private Permission permission;
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    
}
