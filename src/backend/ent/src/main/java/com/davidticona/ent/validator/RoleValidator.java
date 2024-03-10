package com.davidticona.ent.validator;

import com.davidticona.ent.domain.dto.role.RoleRequestDto;
import com.davidticona.ent.domain.dto.role.RoleUpdateRequestDto;
import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.repository.RoleRepository;
import com.davidticona.ent.exceptions.ConflictException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Service
public class RoleValidator {

    @Autowired
    private RoleRepository repository;
    
    public  void validateBeforeCreate(RoleRequestDto role) {
        List<String> errors = new LinkedList<>();
        if (repository.existsByCodeAndApplicationId(role.code(), role.applicationId())) {
            errors.add("Code exists");
        }
        if (!repository.findByIdAndApplicationId(role.parentId(), role.applicationId()).isPresent()) {
            errors.add("parent id does not exists");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateBeforeUpdate(Role role, RoleUpdateRequestDto roleDto) {
        List<String> errors = new LinkedList<>();
        if (repository.existsByCodeAndApplicationId(roleDto.code(), role.getApplicationId(), role.getId())) {
            errors.add("Code already exists");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateBeforeDelete(Integer id) {
        List<String> errors = new LinkedList<>();
        if (repository.countUsers(id) > 0) {
            errors.add("Unable to delete record as it has associated users");
        }
        if (repository.countPermissions(id) > 0) {
            errors.add("Unable to delete record as it has associated permissions");
        }
        if (repository.countChildren(id) > 0) {
            errors.add("Unable to delete record as it has associated roles");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateOnCreateRoot(Integer applicationId) {
        List<String> errors = new LinkedList<>();
        if (repository.existsRootByApplicationId(applicationId)) {
            errors.add("This application has a root");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
}
