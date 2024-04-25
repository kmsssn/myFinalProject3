package kz.myfinalproject.service;

import kz.myfinalproject.dto.GradeDTO;
import kz.myfinalproject.mapper.GradeMapper;
import kz.myfinalproject.repository.GradeRepository;
import kz.myfinalproject.repository.SubjectRepository;
import kz.myfinalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<GradeDTO> getAllGrades() {
        return gradeMapper.toDTOList(gradeRepository.findAll());
    }
}
