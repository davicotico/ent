package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.RoleProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    List<Role> findByApplicationId(Integer applicationId);
    
    @Query(value = """
                   SELECT r.id, r.parent_id as parentId, r.code, r.name
                   FROM ent.role as r
                   WHERE r.application_id = :applicationId
                   """, nativeQuery = true)
    List<RoleProjection> findAll(@Param("applicationId") Integer applicationId);
    
    @Query(value = """
                   with recursive c as (
                   select p.id, p.parent_id, p.code, p.name, true as is_root
                   from ent.role_permission rp 
                   inner join ent."permission" p on (rp.permission_id = p.id)
                   where rp.role_id = :roleId and p.application_id = :applicationId
                   union all
                   select pr.id, pr.parent_id, pr.code, pr.name, false as is_root
                   from ent."permission" as pr
                   join c on c.id = pr. parent_id
                   )
                   select id, parent_id as parentId, code, name, is_root as isRoot
                   from c
                   order by id asc
                   """, nativeQuery = true)
    List<AdjacentItemProjection> getPermissionsTreesByRoleId(
            @Param("applicationId") Integer applicationId,
            @Param("roleId") Integer roleId
    );
    
    @Query(value = """
                   select p.id, p.parent_id as parentId, p.code, p.name
                   from ent.role_permission rp 
                   inner join ent."permission" p on (rp.permission_id = p.id)
                   where rp.role_id = :roleId and p.application_id = :applicationId
                   """, nativeQuery = true)
    List<AdjacentItemProjection> getPermissionsByRoleId(
            @Param("roleId") Integer roleId,
            @Param("applicationId") Integer applicationId
    );

    @Query(value = """
                   select count(*) as c
                   from ent.user_role as ur
                   where ur.role_id = :roleId
                   """, nativeQuery = true)
    Integer countUsers(@Param("roleId") Integer roleId);

    @Query(value = """
                   select count(*) as c
                   from ent.role_permission as rp
                   where rp.role_id = :roleId
                   """, nativeQuery = true)
    Integer countPermissions(@Param("roleId") Integer roleId);
    
    @Query(value = """
                   select count(*) as c
                   from ent."role" as r
                   where r.parent_id = :roleId
                   """, nativeQuery = true)
    Integer countChildren(@Param("roleId") Integer roleId);
}
