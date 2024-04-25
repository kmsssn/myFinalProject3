package kz.myfinalproject.api;

import kz.myfinalproject.dto.GradeDTO;
import kz.myfinalproject.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
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


