package cherniavskiy.service;

import cherniavskiy.db.dao.ClientRepository;
import cherniavskiy.db.dao.OrderRepository;
import cherniavskiy.db.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        try {
            orderRepository.deleteById(id);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            //for the reason of idempotency leave this blank
        }
    }

    @Override
    public Order add(Integer id, Double grade, Double price, String start_place, String end_place, String date, String date_start, String date_end, Integer fk_to_id, Integer fk_client_id) {
        return orderRepository.save(new Order(id, grade, price, start_place, end_place, date, date_start, date_end, fk_to_id, fk_client_id));
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).get();
    }

}
