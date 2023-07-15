package kz.bitlab.myfinalproject.service;

import kz.bitlab.myfinalproject.dto.FacultyDTO;
import kz.bitlab.myfinalproject.mapper.FacultyMapper;
import kz.bitlab.myfinalproject.models.Faculty;
import kz.bitlab.myfinalproject.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyMapper facultyMapper;

    public FacultyDTO getFacultyById(Long id) {

        return facultyMapper.toDTO(facultyRepository.findById(id).orElse(null));
        }

    public List<FacultyDTO> getAllFaculties() {
        return facultyMapper.toDTOList(facultyRepository.findAll());
    }
}