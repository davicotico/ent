package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.AppUser;
import com.davidticona.ent.domain.entity.AppUserId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface AppUserRepository extends JpaRepository<AppUser, AppUserId>{
    
}
