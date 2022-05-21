package cherniavskiy.service;


import cherniavskiy.db.model.TransportOperator;

public interface TransportOperatorService {

    Iterable<TransportOperator> listAll(Integer p);

    void delete(Integer id);

    TransportOperator getById(Integer id);

    Integer count();

    void save(TransportOperator user);

    TransportOperator findByUsername(String username);
}
