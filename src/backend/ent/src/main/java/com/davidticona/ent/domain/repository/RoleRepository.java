package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.AdjacentPermission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    @Query(value = """
                   with recursive c as (
                   select p.id, p.parent_id, p.code, p.name, true as is_root
                   from ent.role_permission rp 
                   inner join ent."permission" p on (rp.permission_id = p.id)
                   where rp.role_id = :roleId and p.application_id = :applicationId
                   
                   union all
                   
                   select pr.id, pr.parent_id, pr.code, pr.name, false as is_root
                   from ent."permission" as pr -- recursive
                   join c on c.id = pr. parent_id
                   )
                   
                   select id, parent_id as parentId, code, name, is_root as isRoot
                   from c
                   order by id asc
                   """, nativeQuery = true)
    List<AdjacentPermission> getPermissionsByRoleId(
            @Param("roleId") Integer roleId,
            @Param("applicationId") Integer applicationId
    );
}
