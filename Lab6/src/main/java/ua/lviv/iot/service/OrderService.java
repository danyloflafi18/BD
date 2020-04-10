package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() throws Exception {
        List<Order> orders = new LinkedList<>(orderRepository.findAll());
        if (orders.isEmpty()) {
            return null;
        }
        return orders;
    }

    public Order findById(Integer id) throws Exception {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Order entity) throws Exception {
        if (entity != null) {
            orderRepository.save(entity);
        }
    }

    @Transactional
    public void update(Order entity) throws Exception {
        orderRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setFromDepartmentId(entity.getFromDepartmentId());
                    oldEntity.setToDepartmentId(entity.getToDepartmentId());
                    oldEntity.setFromOperatorId(entity.getFromOperatorId());
                    oldEntity.setToOperatorId(entity.getToOperatorId());
                    oldEntity.setFromCourierId(entity.getFromCourierId());
                    oldEntity.setToCourierId(entity.getToCourierId());
                    oldEntity.setFromClientId(entity.getFromClientId());
                    oldEntity.setToClientId(entity.getToClientId());
                    oldEntity.setDeliveryPrice(entity.getDeliveryPrice());
                    oldEntity.setProductPrice(entity.getProductPrice());
                    oldEntity.setWeight(entity.getWeight());
                    oldEntity.setSendingDate(entity.getSendingDate());
                    oldEntity.setApproximateArrivalDate(entity.getApproximateArrivalDate());
                    oldEntity.setFixedArrivalDate(entity.getFixedArrivalDate());
                    return orderRepository.save(oldEntity);
                })
                .orElseGet(() -> orderRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
        }
    }
}
