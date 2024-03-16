package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Embeddable

public class RolePermissionId implements Serializable{

    public RolePermissionId() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.roleId);
        hash = 47 * hash + Objects.hashCode(this.permissionId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RolePermissionId other = (RolePermissionId) obj;
        if (!Objects.equals(this.roleId, other.roleId)) {
            return false;
        }
        return Objects.equals(this.permissionId, other.permissionId);
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "role_id")
    private Integer roleId;
    
    @Column(name = "permission_id")
    private Integer permissionId;

    public RolePermissionId(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
    
    
}
