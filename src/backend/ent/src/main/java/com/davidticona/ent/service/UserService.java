package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.user.UserRequestDto;
import com.davidticona.ent.domain.dto.user.UserResponseDto;
import com.davidticona.ent.domain.dto.user.UserUpdateRequestDto;
import com.davidticona.ent.domain.projection.UserProjection;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.util.Tree.TreeNode;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface UserService {
    UserResponseDto create(UserRequestDto user);
    List<UserProjection> read(Integer applicationId);
    
    void update(Integer id, UserUpdateRequestDto user);
    void delete(Integer id);
    
    boolean userExists(Integer id);
    boolean userHasRoles(Integer id);
    
    void authenticate();
    List<String> getAuthorizationList();
    
    List<AdjacentItem> getRoles(Integer applicationId, Integer userId);
    List<TreeNode> getRolesTrees(Integer applicationId, Integer roleId);
    
    boolean hasApplications(Integer userId);
    boolean hasRoles(Integer userId);
    
    void addRole(Integer applicationId, Integer userId, Integer roleId);
    void removeRole(Integer applicationId, Integer userId, Integer roleId);
    
}
