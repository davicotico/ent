package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.RoleRequestDto;
import com.davidticona.ent.domain.dto.RoleResponseDto;
import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.domain.entity.Role;
import com.davidticona.ent.domain.projection.AdjacentItemProjection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    Role toEntity(RoleRequestDto role);
    RoleResponseDto toDto(Role role);
    
    AdjacentItem entityToAdjacentItem(Role item);
    List<AdjacentItem> entityToAdjacentItem(List<Role> item);
    
    AdjacentItem toAdjacentItem(AdjacentItemProjection item);
    List<AdjacentItem> toAdjacentItem(List<AdjacentItemProjection> item);
}
