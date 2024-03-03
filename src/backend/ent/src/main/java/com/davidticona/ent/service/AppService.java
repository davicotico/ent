package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
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
}
