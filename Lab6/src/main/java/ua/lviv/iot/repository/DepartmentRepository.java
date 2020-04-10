package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
