package com.davidticona.ent.validator;

import com.davidticona.ent.domain.dto.permission.PermissionRequestDto;
import com.davidticona.ent.domain.dto.permission.PermissionUpdateRequestDto;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.repository.PermissionRepository;
import com.davidticona.ent.exceptions.ConflictException;
import jakarta.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Service
public class PermissionValidator {

    @Autowired
    PermissionRepository repository;
    
    public void validateBeforeCreate(PermissionRequestDto permission) {
        List<String> errors = new LinkedList<>();
        if (!repository.findByIdAndApplicationId(permission.parentId(), permission.applicationId())
                .isPresent()) {
            throw new EntityNotFoundException("Parent Role is not found");
        }
        if (repository.existsByCodeAndApplicationId(permission.code(), permission.applicationId())) {
            errors.add("Code already exists");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateBeforeUpdate(Permission permission, PermissionUpdateRequestDto permissionDto) {
        List<String> errors = new LinkedList<>();
        if (repository.existsByCodeAndApplicationId(
                permissionDto.code(), 
                permission.getApplicationId(), 
                permission.getId())) {
            errors.add("Code already exists");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateBeforeDelete(Integer id) {
        List<String> errors = new LinkedList<>();
        if (repository.countRoles(id) > 0) {
            errors.add("Unable to delete record as it has associated roles");
        }
        if ((repository.countChildren(id) > 0)) {
            errors.add("Unable to delete record as it has associated permissions");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
}
