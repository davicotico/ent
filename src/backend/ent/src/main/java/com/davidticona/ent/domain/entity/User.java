package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Entity
public class User {
    @Id
    Integer id;
    
    @Column
    String username;
    
    @Column
    String passwordSalt;
    
    @Column
    String passwordHash;
    
    @Column
    String email;
    
    @Column
    Boolean isConfirmedEmail;
    
}
