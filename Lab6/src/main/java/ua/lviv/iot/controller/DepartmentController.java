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
import ua.lviv.iot.model.Department;
import ua.lviv.iot.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> findAll() throws Exception {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{id}")
    public Department findById(@PathVariable Integer id) throws Exception {
        return departmentService.findById(id);
    }

    @PostMapping("/departments")
    public void create(@RequestBody Department entity) throws Exception {
        departmentService.create(entity);
    }

    @PutMapping("/departments/{id}")
    public void update(@PathVariable Integer id, @RequestBody Department entity) throws Exception {
        entity.setId(id);
        departmentService.update(entity);
    }

    @DeleteMapping("/departments/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        departmentService.delete(id);
    }
}
