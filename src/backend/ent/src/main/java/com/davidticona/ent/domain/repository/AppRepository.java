package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface AppRepository extends JpaRepository<AppEntity, Integer> {
    
}
