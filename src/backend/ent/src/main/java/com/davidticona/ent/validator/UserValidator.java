package com.davidticona.ent.validator;

import com.davidticona.ent.domain.dto.user.UserRequestDto;
import com.davidticona.ent.domain.dto.user.UserUpdateRequestDto;
import com.davidticona.ent.domain.entity.AppUserId;
import com.davidticona.ent.domain.repository.AppRepository;
import com.davidticona.ent.domain.repository.AppUserRepository;
import com.davidticona.ent.domain.repository.UserRepository;
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
public class UserValidator {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private AppRepository appRepository;
    
    @Autowired
    private AppUserRepository appUserRepository;
    
    public void validateBeforeCreate(UserRequestDto userDto) {
        List<String> errors = new LinkedList<>();
        if (repository.existsByUsername(userDto.username())) {
            errors.add("Username exists");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateBeforeUpdate(Integer id, UserUpdateRequestDto userDto) {
        List<String> errors = new LinkedList<>();
        if (repository.existsByUsername(userDto.username(), id)) {
            errors.add("Username exists");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void validateBeforeDelete(Integer id) {
        List<String> errors = new LinkedList<>();
        if (repository.countApplications(id) > 0) {
            errors.add("Unable to delete record as it has associated applications");
        }
        if (repository.countRoles(id) > 0) {
            errors.add("Unable to delete record as it has associated roles");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
    
    public void beforeAddRole(Integer applicationId, Integer userId) {
        if (!appRepository.existsById(applicationId)) {
            throw new EntityNotFoundException("Application was not found");
        }
        AppUserId appUserId = new AppUserId(applicationId, userId);
        if (!appUserRepository.existsById(appUserId)) {
            throw new EntityNotFoundException("Application - User was not found");
        }
    }
}
