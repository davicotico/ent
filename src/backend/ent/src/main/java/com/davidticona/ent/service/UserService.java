package com.davidticona.ent.service;

import com.davidticona.ent.domain.entity.User;
import com.davidticona.ent.domain.projection.UserProjection;
import com.davidticona.ent.util.Tree.AdjacentItem;
import java.util.List;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public interface UserService {
    void create(User user);
    List<UserProjection> read(Integer applicationId);
    void update(Integer id, User user);
    void delete(Integer id);
    
    boolean userExists(Integer id);
    boolean userHasRoles(Integer id);
    
    void authenticate();
    List<String> getAuthorizationList();
    
    List<AdjacentItem> getRoles(Integer applicationId, Integer userId);
    void addRole(Integer roleId);
    void addRole(List<Integer> roleIds);
    void removeRole(Integer roleId);
    void removeRole(List<Integer> roleIds);
    
}
