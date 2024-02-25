package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.dto.TreeNode;
import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.RoleProjection;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleService {
    void create(Role role);
    void update(Integer id, Role role);
    void delete(Integer id);
    
    List<Role> getAll();
    List<RoleProjection> getAll(Integer applicationId);
    
    boolean roleExists(Integer id);
    boolean roleExists(List<Integer> ids);
    
    List<AdjacentItem> getPermissions(Integer roleId, Integer applicationId);
    List<TreeNode> getPermissionsTrees(Integer roleId, Integer applicationId);
    
    void addPermission(Integer permissionId);
    void removePermission(Integer permissionId);
}
