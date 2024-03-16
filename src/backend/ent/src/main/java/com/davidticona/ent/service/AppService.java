package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.app.AppRequestDto;
import com.davidticona.ent.domain.dto.app.AppResponseDto;
import java.util.List;

/**
 *
 * @author David Tomas Ticona
 */
public interface AppService {
    List<AppResponseDto> getAll();
    AppResponseDto create(AppRequestDto app);
    AppResponseDto update(Integer id, AppRequestDto app);
    void delete(Integer id);
    
    void addUser(Integer id, Integer userId);
    void removeUser(Integer id, Integer userId);
    
    boolean hasUsers(Integer applicationId);
    boolean hasRoles(Integer applicationId);
    boolean hasPermissions(Integer applicationId);
}
