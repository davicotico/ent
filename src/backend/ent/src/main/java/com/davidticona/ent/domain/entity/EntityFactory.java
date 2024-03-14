
package com.davidticona.ent.domain.entity;

import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.entity.Role;

/**
 *
 * @author David Tomas Ticona Saravia
 */
public class EntityFactory {
    public static Role rootRole(Integer applicationId) {
        Role newRole = new Role();
        newRole.setApplicationId(applicationId);
        newRole.setParentId(null);
        newRole.setCode("root");
        newRole.setName("root");
        return newRole;
    }
    public static Permission rootPermission(Integer applicationId) {
        Permission p = new Permission();
        p.setApplicationId(applicationId);
        p.setParentId(null);
        p.setCode("root");
        p.setName("root");
        return p;
    }
}
