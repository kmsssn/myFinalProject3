package kz.myfinalproject.repository;

import jakarta.transaction.Transactional;
import kz.myfinalproject.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
