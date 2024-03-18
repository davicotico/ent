package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Data
@Entity
@Table(schema = "ent", name = "application")
public class AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Column
    UUID applicationKey;

    @Column
    String code;
    
    @Column
    String name;
    
    @Column
    String description;
    
    @Column
    String url;
    
    @Column
    String version;
    
    @OneToMany(mappedBy = "application")
    Set<AppUser> applicationsUsers = new HashSet<>();
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    LocalDateTime createdAt;
    
    @Column
    private LocalDateTime updatedAt;
    
    @Column
    String lastUser;
    
    @PreUpdate
    public final void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
