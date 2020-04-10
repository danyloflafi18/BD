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
import ua.lviv.iot.model.Courier;
import ua.lviv.iot.service.CourierService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class CourierController {
    @Autowired
    CourierService courierService;

    @GetMapping("/couriers")
    public List<Courier> findAll() throws Exception {
        return courierService.findAll();
    }

    @GetMapping("/couriers/{id}")
    public Courier findById(@PathVariable Integer id) throws Exception {
        return courierService.findById(id);
    }

    @PostMapping("/couriers")
    public void create(@RequestBody Courier entity) throws Exception {
        courierService.create(entity);
    }

    @PutMapping("/couriers/{id}")
    public void update(@PathVariable Integer id, @RequestBody Courier entity) throws Exception {
        entity.setId(id);
        courierService.update(entity);
    }

    @DeleteMapping("/couriers/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        courierService.delete(id);
    }
}
