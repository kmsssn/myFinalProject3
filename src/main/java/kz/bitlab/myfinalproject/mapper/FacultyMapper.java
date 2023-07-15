package kz.bitlab.myfinalproject.mapper;

import kz.bitlab.myfinalproject.dto.FacultyDTO;
import kz.bitlab.myfinalproject.models.Faculty;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacultyMapper {

    FacultyDTO toDTO(Faculty faculty);

    Faculty toModel(FacultyDTO facultyDTO);

    List<FacultyDTO> toDTOList(List<Faculty> facultyList);
    List<Faculty> toModelList(List<FacultyDTO> facultyDTOList);

}

