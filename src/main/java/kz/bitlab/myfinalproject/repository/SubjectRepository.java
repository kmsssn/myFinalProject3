package kz.bitlab.myfinalproject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.myfinalproject.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Long> {
        List<Subject> findByCourseIdAndFacultyId(Long courseId, Long facultyId);
}
