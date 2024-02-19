package com.davidticona.ent.service;

import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.entity.User;
import java.util.List;

/**
 *
 * @author David Tomas Ticona
 */
public interface PermissionService {
    void create(Permission permission);
    List<User> read();
    void update(Integer id, Permission permission);
    void delete(Integer id);
    
    boolean permissionExists(Integer id);
    boolean permissionExists(List<Integer> ids);
}
