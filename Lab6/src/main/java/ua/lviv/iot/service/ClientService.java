package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Client;
import ua.lviv.iot.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll() throws Exception {
        List<Client> clients = new LinkedList<>(clientRepository.findAll());
        if (clients.isEmpty()) {
            return null;
        }
        return clients;
    }

    public Client findById(Integer id) throws Exception {
        if (clientRepository.findById(id).isPresent()) {
            return clientRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Client entity) throws Exception {
        if (entity != null) {
            clientRepository.save(entity);
        }
    }

    @Transactional
    public void update(Client entity) throws Exception {
        clientRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setName(entity.getName());
                    oldEntity.setSurname(entity.getSurname());
                    oldEntity.setPhone(entity.getPhone());
                    oldEntity.setAddress(entity.getAddress());
                    return clientRepository.save(oldEntity);
                })
                .orElseGet(() -> clientRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
        }
    }
}
