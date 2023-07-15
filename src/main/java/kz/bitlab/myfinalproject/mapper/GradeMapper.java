package kz.bitlab.myfinalproject.mapper;

import kz.bitlab.myfinalproject.dto.GradeDTO;
import kz.bitlab.myfinalproject.models.Grade;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    GradeDTO toDTO(Grade grade);

    Grade toModel(GradeDTO gradeDTO);

    List<GradeDTO> toDTOList(List<Grade> grades);

    List<Grade> toModelList(List<GradeDTO> gradeDTOs);
}
