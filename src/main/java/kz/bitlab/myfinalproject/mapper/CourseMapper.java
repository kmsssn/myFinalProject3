package kz.bitlab.myfinalproject.mapper;

import kz.bitlab.myfinalproject.dto.CourseDTO;
import kz.bitlab.myfinalproject.models.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDTO(Course course);

    Course toModel(CourseDTO courseDTO);

    List<CourseDTO> toDTOList(List<Course> courseList);
    List<Course> toModelList(List<CourseDTO> courseDTOList);

}
