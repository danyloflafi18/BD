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
import ua.lviv.iot.model.Operator;
import ua.lviv.iot.service.OperatorService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class OperatorController {
    @Autowired
    OperatorService operatorService;

    @GetMapping("/operators")
    public List<Operator> findAll() throws Exception {
        return operatorService.findAll();
    }

    @GetMapping("/operators/{id}")
    public Operator findById(@PathVariable Integer id) throws Exception {
        return operatorService.findById(id);
    }

    @PostMapping("/operators")
    public void create(@RequestBody Operator entity) throws Exception {
        operatorService.create(entity);
    }

    @PutMapping("/operators/{id}")
    public void update(@PathVariable Integer id, @RequestBody Operator entity) throws Exception {
        entity.setId(id);
        operatorService.update(entity);
    }

    @DeleteMapping("/operators/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        operatorService.delete(id);
    }
}
