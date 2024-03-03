package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.app.AppRequestDto;
import com.davidticona.ent.domain.dto.app.AppResponseDto;
import com.davidticona.ent.domain.entity.AppEntity;
import java.util.List;
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
    List<AppResponseDto> toDto(List<AppEntity> apps);
}
