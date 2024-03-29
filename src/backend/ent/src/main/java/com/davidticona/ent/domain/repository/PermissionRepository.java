package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Permission;
import java.util.List;
import java.util.Optional;
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

    @Query(value = """
                   select count(*) as c
                   from ent.role_permission as rp
                   where rp.permission_id = :permissionId
                   """, nativeQuery = true)
    Integer countRoles(@Param("permissionId") Integer id);
    
    @Query(value = """
                   select count(*) as c
                   from ent."permission" as p
                   where p.parent_id = :permissionId
                   """, nativeQuery = true)
    Integer countChildren(@Param("permissionId") Integer id);
    
    Optional<Permission> findByIdAndApplicationId(Integer id, Integer applicationId);
    
    boolean existsByCodeAndApplicationId(String code, Integer applicationId);
    
    @Query(value = """
                   select
                   case
                      when (select COUNT(*) from ent."permission" as p
                      where (p.code = :code and p.application_id = :applicationId and p.id <> :id)) > 0 
                      then true
                      else false
                   end as e
                   """, nativeQuery = true)
    boolean existsByCodeAndApplicationId(
            @Param("code") String code, 
            @Param("applicationId") Integer applicationId, 
            @Param("id") Integer ignoredId);
}
