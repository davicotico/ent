package com.davidticona.ent.domain.repository;

import com.davidticona.ent.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
