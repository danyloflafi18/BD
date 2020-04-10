package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.DepartmentType;

@Repository
public interface DepartmentTypeRepository extends JpaRepository<DepartmentType, String> {
}
