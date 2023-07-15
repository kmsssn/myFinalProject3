package kz.bitlab.myfinalproject.service;

import kz.bitlab.myfinalproject.dto.FacultyDTO;
import kz.bitlab.myfinalproject.dto.SubjectDTO;
import kz.bitlab.myfinalproject.dto.UserDTO;
import kz.bitlab.myfinalproject.mapper.SubjectMapper;
import kz.bitlab.myfinalproject.models.User;
import kz.bitlab.myfinalproject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    public List<SubjectDTO> getAllSubjects() {
        return subjectMapper.toDTOList(subjectRepository.findAll());
    }

    public SubjectDTO getSubjectById(Long id) {

        return subjectMapper.toDTO(subjectRepository.findById(id).orElse(null));
    }

    public List<SubjectDTO> getSubjectsByCourseAndFaculty(Long courseId, Long facultyId) {
        return subjectMapper.toDTOList(subjectRepository.findByCourseIdAndFacultyId(courseId, facultyId));
    }
}