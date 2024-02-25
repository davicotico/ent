package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.projection.PermissionProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    @Query(value = """
                   SELECT p.id, p.parent_id as parentId, p.code, p.name
                   FROM ent.permission as p
                   WHERE p.application_id = :applicationId
                   """, nativeQuery = true)
    List<PermissionProjection> getAllPermissions(
            @Param("applicationId") Integer applicationId);
}
