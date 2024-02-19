package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Entity
public class Role {
    @Id
    Integer id;
    
    @Column
    String code;
    
    @Column
    String name;
    
    LocalDate createdAt;
    
    @Column
    String lastUser;
}
