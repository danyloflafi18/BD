package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.DepartmentType;
import ua.lviv.iot.repository.DepartmentTypeRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class DepartmentTypeService {
    @Autowired
    DepartmentTypeRepository departmentTypeRepository;

    public List<DepartmentType> findAll() throws Exception {
        List<DepartmentType> departmentTypes = new LinkedList<>(departmentTypeRepository.findAll());
        if (departmentTypes.isEmpty()) {
            return null;
        }
        return departmentTypes;
    }

    public DepartmentType findById(String size) throws Exception {
        if (departmentTypeRepository.findById(size).isPresent()) {
            return departmentTypeRepository.findById(size).get();
        }
        return null;
    }

    @Transactional
    public void create(DepartmentType entity) throws Exception {
        if (entity != null) {
            departmentTypeRepository.save(entity);
        }
    }

    @Transactional
    public void update(DepartmentType entity) throws Exception {
        departmentTypeRepository.findById(entity.getSize())
                .map(oldEntity -> {
                    oldEntity.setMaxWeight(entity.getMaxWeight());
                    return departmentTypeRepository.save(oldEntity);
                })
                .orElseGet(() -> departmentTypeRepository.save(entity));
    }

    @Transactional
    public void delete(String size) throws Exception {
        if (departmentTypeRepository.findById(size).isPresent()) {
            departmentTypeRepository.deleteById(size);
        }
    }
}
