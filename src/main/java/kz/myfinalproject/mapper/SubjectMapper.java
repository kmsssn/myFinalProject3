package kz.myfinalproject.mapper;

import kz.myfinalproject.dto.SubjectDTO;
import kz.myfinalproject.models.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDTO(Subject subject);

    Subject toModel(SubjectDTO subjectDTO);

    List<SubjectDTO> toDTOList(List<Subject> subjectList);
    List<Subject> toModelList(List<SubjectDTO> subjectDTOList);

}
