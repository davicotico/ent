package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.projection.AdjacentPermission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    @Query(value = """
                   select p.id, 
                   p.parent_id as parentId,
                   p.code, p.name
                   from ent.permission as p
                   """, nativeQuery = true)
    List<AdjacentPermission> getAllPermissions();
}
