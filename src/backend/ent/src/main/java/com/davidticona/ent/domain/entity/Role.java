package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Table(name="role", schema = "ent")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Column
    Integer applicationId;
    
    @Column
    Integer parentId;
    
    @Column
    String code;
    
    @Column
    String name;
    
    @OneToMany(mappedBy = "role")
    Set<UserRole> usersRoles = new HashSet<>();
    
    @OneToMany(mappedBy = "role")
    Set<RolePermission> rolesPermissions = new HashSet<>();
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    LocalDateTime createdAt;
    
    @Column
    private LocalDateTime updatedAt;
    
    @Column
    String lastUser;
    
    @PreUpdate
    public final void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
