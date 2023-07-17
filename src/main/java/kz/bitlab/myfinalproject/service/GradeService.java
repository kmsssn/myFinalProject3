package kz.bitlab.myfinalproject.service;

import kz.bitlab.myfinalproject.dto.GradeDTO;
import kz.bitlab.myfinalproject.dto.SubjectDTO;
import kz.bitlab.myfinalproject.mapper.GradeMapper;
import kz.bitlab.myfinalproject.models.Grade;
import kz.bitlab.myfinalproject.models.Subject;
import kz.bitlab.myfinalproject.models.User;
import kz.bitlab.myfinalproject.repository.GradeRepository;
import kz.bitlab.myfinalproject.repository.SubjectRepository;
import kz.bitlab.myfinalproject.repository.UserRepository;
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
