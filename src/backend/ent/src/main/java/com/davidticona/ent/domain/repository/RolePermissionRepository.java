package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.RolePermission;
import com.davidticona.ent.domain.entity.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId>{
    
}
