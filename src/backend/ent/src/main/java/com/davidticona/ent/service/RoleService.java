package com.davidticona.ent.service;

import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.entity.User;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleService {
    void create(Role role);
    List<User> read();
    void update(Integer id, Role role);
    void delete(Integer id);
    
    boolean roleExists(Integer id);
    boolean roleExists(List<Integer> ids);
    
    void addPermission(Integer permissionId);
    void removePermission(Integer permissionId);
}
