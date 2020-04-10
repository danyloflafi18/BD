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
import ua.lviv.iot.model.City;
import ua.lviv.iot.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public List<City> findAll() throws Exception {
        return cityService.findAll();
    }

    @GetMapping("/cities/{id}")
    public City findById(@PathVariable String id) throws Exception {
        return cityService.findById(id);
    }

    @PostMapping("/cities")
    public void create(@RequestBody City entity) throws Exception {
        cityService.create(entity);
    }

    @PutMapping("/cities/{name}")
    public void update(@PathVariable String name, @RequestBody City entity) throws Exception {
        cityService.update(name, entity.getName());
    }

    @DeleteMapping("/cities/{id}")
    public void delete(@PathVariable String id) throws Exception {
        cityService.delete(id);
    }
}
