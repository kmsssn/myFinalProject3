package kz.bitlab.myfinalproject.mapper;

import kz.bitlab.myfinalproject.dto.FacultyDTO;
import kz.bitlab.myfinalproject.dto.SubjectDTO;
import kz.bitlab.myfinalproject.models.Faculty;
import kz.bitlab.myfinalproject.models.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDTO(Subject subject);

    Subject toModel(SubjectDTO subjectDTO);

    List<SubjectDTO> toDTOList(List<Subject> subjectList);
    List<Subject> toModelList(List<SubjectDTO> subjectDTOList);

}
