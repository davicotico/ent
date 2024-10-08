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
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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
    
    @OneToMany(mappedBy = "user")
    Set<AppUser> applicationsUsers = new HashSet<>();
    
    @OneToMany(mappedBy = "user")
    Set<UserRole> usersRoles = new HashSet<>();
    
    @Column
    String username;
    
    @Column(name = "password_salt")
    String passw;
    
    @Column
    String email;
    
    @Column
    Boolean isValidEmail;
    
    @Column
    Boolean active = false;
    
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
