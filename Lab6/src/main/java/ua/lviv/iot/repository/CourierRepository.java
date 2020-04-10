package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {
}
