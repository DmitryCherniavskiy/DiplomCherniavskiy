package cherniavskiy.service;

import cherniavskiy.db.dao.TransportRepository;
import cherniavskiy.db.model.Transport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransportServiceImpl implements TransportService{
    @Autowired
    private TransportRepository transportRepository;

    @Override
    public Iterable<Transport> listAll() {
        return transportRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        try {
            transportRepository.deleteById(id);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            //for the reason of idempotency leave this blank
        }
    }

    @Override
    public Transport add(Integer id, String model, String transport_class, String description, String image, Integer year, Integer fk_to_id) {
        return transportRepository.save(new Transport(id, model, transport_class, description, image, year, fk_to_id));
    }

    @Override
    public Transport getById(Integer id) {
        return transportRepository.findById(id).orElse(null);
    }

}