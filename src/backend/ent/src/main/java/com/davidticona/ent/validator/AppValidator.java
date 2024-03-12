package com.davidticona.ent.validator;

import com.davidticona.ent.domain.dto.app.AppRequestDto;
import com.davidticona.ent.domain.repository.AppRepository;
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
public class AppValidator {

    @Autowired
    AppRepository repository;

    public void validateBeforeCreate(AppRequestDto appDto) {
        List<String> errors = new LinkedList<>();
        if (repository.existsByCode(appDto.code())) {
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
        if (repository.countRoles(id) > 0) {
            errors.add("Unable to delete record as it has associated roles");
        }
        if (repository.countPermissions(id) > 0) {
            errors.add("Unable to delete record as it has associated permissions");
        }
        if (!errors.isEmpty()) {
            throw new ConflictException(errors);
        }
    }
}
