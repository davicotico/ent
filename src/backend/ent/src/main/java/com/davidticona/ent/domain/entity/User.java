package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Table(name = "user", schema = "ent")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    Boolean isValidEmail;
    
    
}
