package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Entity
public class Person {
    @Id
    Integer id;
    
    @Column
    String firstname;
    
    @Column
    String lastname;
    
    @Column
    String fullname;
    
    @Column
    String gender;
    
    @Column
    String birthday;
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
    
    @PreUpdate
    public final void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
