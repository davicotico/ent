package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.AppRequestDto;
import com.davidticona.ent.domain.dto.AppResponseDto;
import com.davidticona.ent.domain.entity.AppEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppMapper {
    AppEntity toEntity(AppRequestDto app);
    AppResponseDto toDto(AppEntity app);
}
