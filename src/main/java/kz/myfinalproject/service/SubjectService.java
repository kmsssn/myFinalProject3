package kz.myfinalproject.service;

import kz.myfinalproject.dto.SubjectDTO;
import kz.myfinalproject.mapper.SubjectMapper;
import kz.myfinalproject.repository.SubjectRepository;
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