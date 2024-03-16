package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.UserRole;
import com.davidticona.ent.domain.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId>{
    
}
