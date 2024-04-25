package kz.myfinalproject.api;

import kz.myfinalproject.dto.SubjectDTO;
import kz.myfinalproject.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectRestController {

    private final SubjectService subjectService;

    @GetMapping
    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/facultyId/{facultyId}/courseId/{courseId}")
    public List<SubjectDTO> getSubjectsByCourseAndFaculty(@PathVariable Long courseId,
                                                       @PathVariable Long facultyId) {
        List<SubjectDTO> subjects = subjectService.getSubjectsByCourseAndFaculty(courseId, facultyId);

        return subjects;
    }


}
