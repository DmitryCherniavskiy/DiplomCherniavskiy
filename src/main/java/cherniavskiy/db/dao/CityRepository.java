package cherniavskiy.db.dao;

import cherniavskiy.db.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {
}
