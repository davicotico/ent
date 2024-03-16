package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.role.RoleRequestDto;
import com.davidticona.ent.domain.dto.role.RoleResponseDto;
import com.davidticona.ent.domain.dto.role.RoleUpdateRequestDto;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.TreeNode;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface RoleService {
    RoleResponseDto create(RoleRequestDto role);
    RoleResponseDto update(Integer id, RoleUpdateRequestDto role);
    void delete(Integer id);
    
    RoleResponseDto createRoot(Integer applicationId);
    
    List<AdjacentItem> getAll(Integer applicationId);
    List<TreeNode> getAllTreeView(Integer applicationId);
    
    boolean roleExists(Integer id);
    boolean roleExists(List<Integer> ids);
    
    boolean hasUsers(Integer id);
    boolean hasPermissions(Integer id);
    boolean hasChildren(Integer id);
    
    List<AdjacentItem> getPermissions(Integer applicationId, Integer roleId);
    List<TreeNode> getPermissionsTrees(Integer applicationId, Integer roleId);
    
    void addPermission(Integer applicationId, Integer roleId, Integer permissionId);
    void removePermission(Integer applicationId, Integer roleId, Integer permissionId);
}
