package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.PermissionRequestDto;
import com.davidticona.ent.domain.dto.PermissionResponseDto;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.domain.entity.Permission;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper {
    Permission toEntity(PermissionRequestDto permission);
    PermissionResponseDto toDto(Permission permission);
    
    AdjacentItem entityToAdjacentItem(Permission item);
    List<AdjacentItem> entityToAdjacentItem(List<Permission> item);
    
    AdjacentItem toAdjacentItem(AdjacentItemProjection item);
    List<AdjacentItem> toAdjacentItem(List<AdjacentItemProjection> item);
}
