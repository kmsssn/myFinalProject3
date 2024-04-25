package kz.myfinalproject.mapper;

import kz.myfinalproject.dto.PermissionDTO;
import kz.myfinalproject.models.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO toDTO(Permission permission);

    Permission toModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toDTOList(List<Permission> permissionList);
    List<Permission> toModelList(List<PermissionDTO> permissionDTOList);

}
