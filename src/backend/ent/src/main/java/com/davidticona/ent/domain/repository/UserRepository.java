package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
