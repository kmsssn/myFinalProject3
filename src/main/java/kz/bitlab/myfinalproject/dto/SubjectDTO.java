package kz.bitlab.myfinalproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDTO {

        private Long id;
        private String name;
        private CourseDTO course;
        private FacultyDTO faculty;
        //private List<GradeDTO> grades;

}
