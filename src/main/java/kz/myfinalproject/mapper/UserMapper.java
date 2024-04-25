package kz.myfinalproject.mapper;

import kz.myfinalproject.dto.UserDTO;
import kz.myfinalproject.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "course.courseNum", target = "courseNum"),
            @Mapping(source = "faculty.name", target = "facultyName"),
    })

    UserDTO toDTO(User user);
    User toModel(UserDTO userDTO);

    List<UserDTO> toDTOList(List<User> userList);
    List<User> toModelList(List<UserDTO> userDTOList);
}
