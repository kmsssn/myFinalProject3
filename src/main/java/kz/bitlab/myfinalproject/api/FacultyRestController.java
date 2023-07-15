package kz.bitlab.myfinalproject.api;

import kz.bitlab.myfinalproject.dto.FacultyDTO;
import kz.bitlab.myfinalproject.dto.UserDTO;
import kz.bitlab.myfinalproject.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@AllArgsConstructor
public class FacultyRestController {

    private final FacultyService facultyService;

    @GetMapping
    public List<FacultyDTO> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

}
