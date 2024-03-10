package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.RoleProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;
import java.util.Optional;

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
    
    @Query(value = """
                   select 
                   case
                     when (select COUNT(*) from ent."role" as r where (r.code = :code and r.application_id = :applicationId)) > 0 
                     then true 
                     else false
                   end as e
                   """, nativeQuery = true)
    boolean existsByCodeAndApplicationId(
            @Param("code") String code,
            @Param("applicationId") Integer applicationId
    );
    
    @Query(value = """
                   select
                   case
                   when (select COUNT(*)
                   from ent."role" as r
                   where (r.code = :code and r.id <> :id and r.application_id = :applicationId)) > 0 
                   then true
                   else false
                   end as e
                   """, nativeQuery = true)
    boolean existsByCodeAndApplicationId(
            @Param("code") String code, 
            @Param("applicationId") Integer applicationId, 
            @Param("id") Integer ignoredId);
    
    Optional<Role> findByIdAndApplicationId(Integer id, Integer applicationId);
    
    @Query(value = """
                   select 
                   case when (count(*) > 0)
                   then true
                   else false
                   end e
                   from ent."role" r 
                   where r.parent_id is null and application_id = :applicationId
                   """, nativeQuery = true)
    boolean existsRootByApplicationId(@Param("applicationId") Integer applicationId);
    
    
}
