package cherniavskiy.service;

import cherniavskiy.db.model.Client;
import cherniavskiy.db.model.Order;

import java.util.List;

public interface ClientService {
    Iterable<Client> listAll();

    void delete(Integer id);

    Client getById(Integer id);

    Client getByTelephone(String telephone);

    List<Order> getOrderByTelephone(String telephone);

    void save(Client user);

    Client findByUsername(String username);

}
