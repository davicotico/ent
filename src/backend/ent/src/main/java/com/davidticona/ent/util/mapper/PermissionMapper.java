package com.davidticona.ent.util.mapper;

import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.domain.entity.Permission;
import com.davidticona.ent.domain.projection.PermissionProjection;
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
    AdjacentItem entityToAdjacentItem(Permission item);
    List<AdjacentItem> entityToAdjacentItem(List<Permission> item);
    
    AdjacentItem toAdjacentItem(AdjacentItemProjection item);
    List<AdjacentItem> toAdjacentItem(List<AdjacentItemProjection> item);
    List<AdjacentItem> toListAdjacentItem(List<PermissionProjection> item);
    
}
