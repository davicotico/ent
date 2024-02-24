package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.TreeNode;
import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.AdjacentPermission;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleService {
    void create(Role role);
    List<Role> read();
    void update(Integer id, Role role);
    void delete(Integer id);
    
    boolean roleExists(Integer id);
    boolean roleExists(List<Integer> ids);
    
    List<AdjacentPermission> getPermissions(Integer roleId, Integer applicationId);
    List<TreeNode> getPermissionsAsTree(Integer roleId, Integer applicationId);
    
    void addPermission(Integer permissionId);
    void removePermission(Integer permissionId);
}
