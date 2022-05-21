package cherniavskiy.service;


import cherniavskiy.db.model.City;

public interface CityService {
    Iterable<City> listAll();

    void delete(Integer id);

    City add(Integer number, String name);

    City getById(Integer id);
}
