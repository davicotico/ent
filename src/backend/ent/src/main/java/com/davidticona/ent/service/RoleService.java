package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.role.RoleRequestDto;
import com.davidticona.ent.domain.dto.role.RoleResponseDto;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Role;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleService {
    RoleResponseDto create(RoleRequestDto role);
    RoleResponseDto update(Integer id, RoleRequestDto role);
    void delete(Integer id);
    
    List<Role> getAll();
    List<AdjacentItem> getAll(Integer applicationId);
    List<TreeNode> getAllTreeView(Integer applicationId);
    
    boolean roleExists(Integer id);
    boolean roleExists(List<Integer> ids);
    
    List<AdjacentItem> getPermissions(Integer applicationId, Integer roleId);
    List<TreeNode> getPermissionsTrees(Integer applicationId, Integer roleId);
    
    void addPermission(Integer permissionId);
    void removePermission(Integer permissionId);
}
