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
import ua.lviv.iot.model.Account;
import ua.lviv.iot.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/chalyi")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> findAll() throws Exception {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable Integer id) throws Exception {
        return accountService.findById(id);
    }

    @PostMapping("/accounts")
    public void create(@RequestBody Account entity) throws Exception {
        accountService.create(entity);
    }

    @PutMapping("/accounts/{id}")
    public void update(@PathVariable Integer id, @RequestBody Account entity) throws Exception {
        entity.setClientId(id);
        accountService.update(entity);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        accountService.delete(id);
    }
}
