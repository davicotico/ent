package com.davidticona.ent.service;

import com.davidticona.ent.domain.entity.Permission;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PermissionService {
    void create(Permission permission);
    List<Permission> read();
    void update(Integer id, Permission permission);
    void delete(Integer id);
    
    boolean permissionExists(Integer id);
    boolean permissionExists(List<Integer> ids);
}
