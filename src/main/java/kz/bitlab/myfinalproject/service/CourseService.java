package kz.bitlab.myfinalproject.service;

import kz.bitlab.myfinalproject.dto.CourseDTO;
import kz.bitlab.myfinalproject.mapper.CourseMapper;
import kz.bitlab.myfinalproject.models.Course;
import kz.bitlab.myfinalproject.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;

    public CourseDTO getCourseById(Long id) {
        return courseMapper.toDTO(courseRepository.findById(id).orElse(null));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
