package com.davidticona.ent.service;

import com.davidticona.ent.util.Tree.TreeNode;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.util.Tree.AdjacentItem;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface PermissionService {
    void create(Permission permission);
    
    List<AdjacentItem> getAll(Integer applicationId);
    List<TreeNode> getAllTreeView(Integer applicationId);
    
    void update(Integer id, Permission permission);
    void delete(Integer id);
    
    boolean permissionExists(Integer id);
    boolean permissionExists(List<Integer> ids);
}
