package com.davidticona.ent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Entity
@Table(name = "application_user", schema = "ent")
@Data
public class AppUser {
    @EmbeddedId
    AppUserId id;
    
    @ManyToOne
    @MapsId("applicationId")
    AppEntity application;
    
    @ManyToOne
    @MapsId("userId")
    User user;
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
