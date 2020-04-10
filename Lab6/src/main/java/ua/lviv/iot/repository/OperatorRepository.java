package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
}
