package kz.bitlab.myfinalproject.api;

import kz.bitlab.myfinalproject.dto.GradeDTO;
import kz.bitlab.myfinalproject.dto.SubjectDTO;
import kz.bitlab.myfinalproject.models.Grade;
import kz.bitlab.myfinalproject.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeRestController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<GradeDTO> getAllGrades() {
        return gradeService.getAllGrades();
    }

}


