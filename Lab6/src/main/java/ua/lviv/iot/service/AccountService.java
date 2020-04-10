package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Account;
import ua.lviv.iot.repository.AccountRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> findAll() throws Exception {
        List<Account> accounts = new LinkedList<>(accountRepository.findAll());
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts;
    }

    public Account findById(Integer id) throws Exception {
        if (accountRepository.findById(id).isPresent()) {
            return accountRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Account entity) throws Exception {
        if (entity != null) {
            accountRepository.save(entity);
        }
    }

    @Transactional
    public void update(Account entity) throws Exception {
        accountRepository.findById(entity.getClientId())
                .map(oldEntity -> {
                    oldEntity.setUsername(entity.getUsername());
                    oldEntity.setPassword(entity.getPassword());
                    oldEntity.setEmail(entity.getEmail());
                    return accountRepository.save(oldEntity);
                })
                .orElseGet(() -> accountRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (accountRepository.findById(id).isPresent()) {
            accountRepository.deleteById(id);
        }
    }
}
