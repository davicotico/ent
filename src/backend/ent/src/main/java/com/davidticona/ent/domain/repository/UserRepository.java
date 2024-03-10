package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.User;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;
import com.davidticona.ent.domain.projection.UserProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = """
           select u.id, u.username, u.email, u.is_valid_email as isValidEmail, u.active, u.created_at as createdAt
           from ent.application_user as au
           inner join ent."user" as u on (au.user_id = u.id)
           where au.application_id = :applicationId
           """, nativeQuery = true)
    List<UserProjection> findAll(@Param("applicationId") Integer applicationId);

    @Query(value = """
                   select r.id, r.parent_id as parentId, r.code, r."name"
                   from ent.user_role ur
                   inner join ent."user" as u on (ur.user_id = u.id)
                   inner join ent."role" as r on (ur.role_id = r.id)
                   where ur.user_id = :userId and r.application_id = :applicationId
                   """, nativeQuery = true)
    List<AdjacentItemProjection> getRolesByUserId(
            @Param("applicationId") Integer applicationId,
            @Param("userId") Integer userId);
    
    @Query(value = """
                   with recursive adj as (
                      select r.id, r.parent_id, r.code, r.name, true as is_root
                      from ent.user_role as ur
                      inner join ent."role" r on (ur.role_id = r.id)
                      where ur.user_id = :userId and r.application_id = :applicationId
                      union all
                      select rr.id, rr.parent_id, rr.code, rr.name, false as is_root
                      from ent."role" as rr -- role recursive
                      join adj on adj.id = rr. parent_id
                   )
                      select id, parent_id as parentId, code, name, is_root as isRoot
                      from adj
                      order by id asc
                   """, nativeQuery = true)
    List<AdjacentItemProjection> getRolesTreesByRoleId(
            @Param("applicationId") Integer applicationId,
            @Param("userId") Integer userId
    );

    @Query(value = """
                   select count(*) as c
                   from ent.application_user au
                   where au.user_id= :userId
                   """, nativeQuery = true)
    Integer hasApplications(Integer userId);
    
    @Query(value = """
                   select count(*) as c
                   from ent.user_role as ur
                   where ur.user_id = :userId
                   """, nativeQuery = true)
    Integer hasRoles(Integer userId);
    
    @Query(value = """
                   select 
                   case
                     when (select COUNT(*) from ent."user" as u where u.username = :username) > 0 
                     then true 
                     else false
                   end  as resultado
                   """, nativeQuery = true)
    boolean existsByUsername(@Param("username") String username);
    
    @Query(value = """
                   select 
                   case
                     when (select COUNT(*) from ent."user" as u where (u.username = :username and u.id <> :userId)) > 0 
                     then true 
                     else false
                   end as resultado
                   """, nativeQuery = true)
    boolean existsByUsername(
            @Param("username") String username,
            @Param("userId") Integer ignoredUserId);
}
