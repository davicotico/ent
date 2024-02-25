package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Permission;
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
                   SELECT p
                   FROM Permission p
                   WHERE p.applicationId = :applicationId
                   """)
    List<Permission> getAllPermissions(
            @Param("applicationId") Integer applicationId);
}
