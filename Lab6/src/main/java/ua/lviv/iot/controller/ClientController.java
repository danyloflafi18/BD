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
import ua.lviv.iot.model.Client;
import ua.lviv.iot.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAll() throws Exception {
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable Integer id) throws Exception {
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    public void create(@RequestBody Client entity) throws Exception {
        clientService.create(entity);
    }

    @PutMapping("/clients/{id}")
    public void update(@PathVariable Integer id, @RequestBody Client entity) throws Exception {
        entity.setId(id);
        clientService.update(entity);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        clientService.delete(id);
    }
}
