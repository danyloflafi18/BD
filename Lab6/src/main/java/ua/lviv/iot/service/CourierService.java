package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Courier;
import ua.lviv.iot.repository.CourierRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class CourierService {
    @Autowired
    CourierRepository courierRepository;

    public List<Courier> findAll() throws Exception {
        List<Courier> couriers = new LinkedList<>(courierRepository.findAll());
        if (couriers.isEmpty()) {
            return null;
        }
        return couriers;
    }

    public Courier findById(Integer id) throws Exception {
        if (courierRepository.findById(id).isPresent()) {
            return courierRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Courier entity) throws Exception {
        if (entity != null) {
            courierRepository.save(entity);
        }
    }

    @Transactional
    public void update(Courier entity) throws Exception {
        courierRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setDepartmentId(entity.getDepartmentId());
                    oldEntity.setName(entity.getName());
                    oldEntity.setSurname(entity.getSurname());
                    oldEntity.setPhone(entity.getPhone());
                    oldEntity.setAddress(entity.getAddress());
                    oldEntity.setBirthday(entity.getBirthday());
                    return courierRepository.save(oldEntity);
                })
                .orElseGet(() -> courierRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (courierRepository.findById(id).isPresent()) {
            courierRepository.deleteById(id);
        }
    }
}
