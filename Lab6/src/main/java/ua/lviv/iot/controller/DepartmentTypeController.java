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
import ua.lviv.iot.model.DepartmentType;
import ua.lviv.iot.service.DepartmentTypeService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class DepartmentTypeController {
    @Autowired
    DepartmentTypeService departmentTypeService;

    @GetMapping("/departmentTypes")
    public List<DepartmentType> findAll() throws Exception {
        return departmentTypeService.findAll();
    }

    @GetMapping("/departmentTypes/{id}")
    public DepartmentType findById(@PathVariable String id) throws Exception {
        return departmentTypeService.findById(id);
    }

    @PostMapping("/departmentTypes")
    public void create(@RequestBody DepartmentType entity) throws Exception {
        departmentTypeService.create(entity);
    }

    @PutMapping("/departmentTypes/{id}")
    public void update(@PathVariable String id, @RequestBody DepartmentType entity) throws Exception {
        entity.setSize(id);
        departmentTypeService.update(entity);
    }

    @DeleteMapping("/departmentTypes/{id}")
    public void delete(@PathVariable String id) throws Exception {
        departmentTypeService.delete(id);
    }
}
