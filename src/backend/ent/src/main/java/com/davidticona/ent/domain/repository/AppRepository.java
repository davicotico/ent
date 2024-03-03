package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface AppRepository extends JpaRepository<AppEntity, Integer> {
    @Query(value = """
                   select count(*) as c
                   from ent.application_user as au
                   where au.application_id = :applicationId
                   """, nativeQuery = true)
    Integer countUsers(@Param("applicationId") Integer applicationId);
    
    @Query(value = """
                   select count(*) as c
                   from ent."role" as r
                   where r.application_id = :applicationId
                   """, nativeQuery = true)
    Integer countRoles(@Param("applicationId") Integer applicationId);

    @Query(value = """
                   select count(*) as c
                   from ent."permission" as r
                   where r.application_id = :applicationId
                   """, nativeQuery = true)
    Integer countPermissions(@Param("applicationId") Integer applicationId);
}
