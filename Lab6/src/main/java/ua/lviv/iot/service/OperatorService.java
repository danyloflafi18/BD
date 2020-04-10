package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Operator;
import ua.lviv.iot.repository.OperatorRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class OperatorService {
    @Autowired
    OperatorRepository operatorRepository;

    public List<Operator> findAll() throws Exception {
        List<Operator> operators = new LinkedList<>(operatorRepository.findAll());
        if (operators.isEmpty()) {
            return null;
        }
        return operators;
    }

    public Operator findById(Integer id) throws Exception {
        if (operatorRepository.findById(id).isPresent()) {
            return operatorRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Operator entity) throws Exception {
        if (entity != null) {
            operatorRepository.save(entity);
        }
    }

    @Transactional
    public void update(Operator entity) throws Exception {
        operatorRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setDepartmentId(entity.getDepartmentId());
                    oldEntity.setName(entity.getName());
                    oldEntity.setSurname(entity.getSurname());
                    oldEntity.setPhone(entity.getPhone());
                    oldEntity.setAddress(entity.getAddress());
                    oldEntity.setBirthday(entity.getBirthday());
                    return operatorRepository.save(oldEntity);
                })
                .orElseGet(() -> operatorRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (operatorRepository.findById(id).isPresent()) {
            operatorRepository.deleteById(id);
        }
    }
}
