package cherniavskiy.service;


import cherniavskiy.db.model.Order;

public interface OrderService {
    Iterable<Order> listAll();

    void delete(Integer id);

    Order add(Integer id, Double grade, Double price, String start_place, String end_place, String date, String date_start, String date_end, Integer fk_to_id, Integer fk_client_id);

    Order getById(Integer id);
}
