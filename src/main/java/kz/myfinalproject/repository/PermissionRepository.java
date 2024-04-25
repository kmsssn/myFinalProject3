package kz.myfinalproject.repository;


import jakarta.transaction.Transactional;
import kz.myfinalproject.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
