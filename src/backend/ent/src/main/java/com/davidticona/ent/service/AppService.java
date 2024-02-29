package com.davidticona.ent.service;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import java.util.List;

/**
 *
 * @author David Tomas Ticona
 */
public interface AppService {
    AppResponseDto create(AppRequestDto app);
    List<AppResponseDto> getAll();
}
