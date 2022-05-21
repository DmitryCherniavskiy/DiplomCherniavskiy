package cherniavskiy.db.dao;

import cherniavskiy.db.model.TransportOperator;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransportOperatorRepository extends CrudRepository<TransportOperator, Integer> {
    List<TransportOperator> findAll(Pageable page);
    Integer countAllBy();
    TransportOperator findByTelephone(String login);
}
