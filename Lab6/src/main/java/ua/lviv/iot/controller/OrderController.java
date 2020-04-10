package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> findAll() throws Exception {
        return orderService.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable Integer id) throws Exception {
        return orderService.findById(id);
    }

    @PostMapping("/orders")
    public void create(@RequestBody Order entity) throws Exception {
        orderService.create(entity);
    }

    @PutMapping("/orders/{id}")
    public void update(@PathVariable Integer id, @RequestBody Order entity) throws Exception {
        entity.setId(id);
        orderService.update(entity);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        orderService.delete(id);
    }
}
