package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    
}
