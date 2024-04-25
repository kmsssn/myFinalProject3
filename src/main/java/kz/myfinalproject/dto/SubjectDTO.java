package kz.myfinalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {

        private Long id;
        private String name;
        private CourseDTO course;
        private FacultyDTO faculty;
        //private List<GradeDTO> grades;

}
