package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
