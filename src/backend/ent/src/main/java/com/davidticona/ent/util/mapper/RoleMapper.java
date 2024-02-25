package com.davidticona.ent.util.mapper;

import com.davidticona.ent.util.Tree.AdjacentItem;
import com.davidticona.ent.domain.entity.Role;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    
    AdjacentItem entityToAdjacentItem(Role item);
    
    List<AdjacentItem> entityToAdjacentItem(List<Role> item);
}
