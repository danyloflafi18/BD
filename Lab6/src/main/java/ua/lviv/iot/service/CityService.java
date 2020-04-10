package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.City;
import ua.lviv.iot.repository.CityRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public List<City> findAll() throws Exception {
        List<City> cities = new LinkedList<>(cityRepository.findAll());
        if (cities.isEmpty()) {
            return null;
        }
        return cities;
    }

    public City findById(String id) throws Exception {
        if (cityRepository.findById(id).isPresent()) {
            return cityRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(City entity) throws Exception {
        cityRepository.save(entity);
    }

    @Transactional
    public void update(String city, String newCity) throws Exception {
        City entity = new City();
        entity.setName(newCity);

        if (cityRepository.findById(city).isPresent()) {
            cityRepository.deleteById(city);
            cityRepository.save(entity);
        }
    }

    @Transactional
    public void delete(String id) throws Exception {
        if (cityRepository.findById(id).isPresent()) {
            cityRepository.deleteById(id);
        }
    }
}
