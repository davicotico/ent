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
public class Permission {
    @Id
    Integer id;
    
    @Column
    String code;
    
    @Column
    String name;
}
