package com.davidticona.ent.util.mapper;

import com.davidticona.ent.domain.dto.AdjacentItem;
import com.davidticona.ent.domain.entity.Permission;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper {
    AdjacentItem entityToAdjacentItem(Permission item);
    
    List<AdjacentItem> entityToAdjacentItem(List<Permission> item);
}
