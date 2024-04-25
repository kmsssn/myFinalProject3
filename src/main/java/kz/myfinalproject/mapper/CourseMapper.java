package kz.myfinalproject.mapper;

import kz.myfinalproject.dto.CourseDTO;
import kz.myfinalproject.models.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDTO(Course course);

    Course toModel(CourseDTO courseDTO);

    List<CourseDTO> toDTOList(List<Course> courseList);
    List<Course> toModelList(List<CourseDTO> courseDTOList);

}
