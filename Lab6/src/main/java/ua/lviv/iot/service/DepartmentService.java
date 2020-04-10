package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Department;
import ua.lviv.iot.repository.DepartmentRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> findAll() throws Exception {
        List<Department> departments = new LinkedList<>(departmentRepository.findAll());
        if (departments.isEmpty()) {
            return null;
        }
        return departments;
    }

    public Department findById(Integer id) throws Exception {
        if (departmentRepository.findById(id).isPresent()) {
            return departmentRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Department entity) throws Exception {
        if (entity != null) {
            departmentRepository.save(entity);
        }
    }

    @Transactional
    public void update(Department entity) throws Exception {
        departmentRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setDepartmentTypeSize(entity.getDepartmentTypeSize());
                    oldEntity.setCityName(entity.getCityName());
                    oldEntity.setNumber(entity.getNumber());
                    oldEntity.setAddress(entity.getAddress());
                    return departmentRepository.save(oldEntity);
                })
                .orElseGet(() -> departmentRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (departmentRepository.findById(id).isPresent()) {
            departmentRepository.deleteById(id);
        }
    }
}
