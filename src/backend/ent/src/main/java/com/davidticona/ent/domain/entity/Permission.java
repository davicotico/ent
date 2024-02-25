package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Table(name="permission", schema = "ent")
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Column
    Integer parentId;
    
    @Column
    String code;
    
    @Column
    String name;
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    
    @Column
    private LocalDateTime updatedAt;
    
    @Column
    String lastUser;
    
    @PreUpdate
    public final void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
