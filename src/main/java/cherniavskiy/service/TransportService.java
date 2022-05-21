package cherniavskiy.service;


import cherniavskiy.db.model.Transport;

public interface TransportService {
    Iterable<Transport> listAll();

    void delete(Integer id);

    Transport add(Integer id, String model, String transport_class, String description, String image, Integer year, Integer fk_to_id);

    Transport getById(Integer id);
}
