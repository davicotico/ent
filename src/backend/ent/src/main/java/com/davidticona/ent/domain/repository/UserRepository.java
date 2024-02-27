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
}
