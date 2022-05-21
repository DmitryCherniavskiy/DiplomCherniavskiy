package cherniavskiy.db.dao;

import cherniavskiy.db.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllBy();

    List<Order> findAllByClient(Integer client_id);
}
