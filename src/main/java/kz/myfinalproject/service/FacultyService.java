package kz.myfinalproject.service;

import kz.myfinalproject.dto.FacultyDTO;
import kz.myfinalproject.mapper.FacultyMapper;
import kz.myfinalproject.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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