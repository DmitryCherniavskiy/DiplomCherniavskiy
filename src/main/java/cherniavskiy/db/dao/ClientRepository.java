package cherniavskiy.db.dao;

import cherniavskiy.db.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client findByTelephone(String login);
}
