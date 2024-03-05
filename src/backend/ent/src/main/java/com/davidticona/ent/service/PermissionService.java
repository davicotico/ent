package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.permission.PermissionRequestDto;
import com.davidticona.ent.domain.dto.permission.PermissionResponseDto;
import com.davidticona.ent.domain.dto.permission.PermissionUpdateRequestDto;
import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.util.Tree.AdjacentItem;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PermissionService {
    PermissionResponseDto create(PermissionRequestDto permission);
    
    List<AdjacentItem> getAll(Integer applicationId);
    List<TreeNode> getAllTreeView(Integer applicationId);
    
    PermissionResponseDto update(Integer id, PermissionUpdateRequestDto permission);
    void delete(Integer id);
    
    boolean hasRoles(Integer id);
    boolean hasChildren(Integer id);
    
    boolean permissionExists(Integer id);
    boolean permissionExists(List<Integer> ids);
}
