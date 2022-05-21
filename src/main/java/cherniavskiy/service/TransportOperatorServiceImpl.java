package cherniavskiy.service;

import cherniavskiy.db.dao.RoleDao;
import cherniavskiy.db.dao.TransportOperatorRepository;
import cherniavskiy.db.model.Role;
import cherniavskiy.db.model.TransportOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class TransportOperatorServiceImpl implements TransportOperatorService{

    @Autowired
    private RoleDao roleDao;


    @Autowired
    private TransportOperatorRepository transportOperatorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Iterable<TransportOperator> listAll(Integer p) {
        Pageable page = PageRequest.of(p, 2, Sort.by(Sort.Direction.DESC,"grade"));
        return transportOperatorRepository.findAll(page);
    }

    @Override
    public void delete(Integer id) {
        try {
            transportOperatorRepository.deleteById(id);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            //for the reason of idempotency leave this blank
        }
    }

    @Override
    public TransportOperator getById(Integer id) {
        return transportOperatorRepository.findById(id).get();
    }

    @Override
    public Integer count(){
        return transportOperatorRepository.countAllBy();
    }

    @Override
    public void save(TransportOperator client) {
        client.setPasshash(bCryptPasswordEncoder.encode(client.getPasshash()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(3));
        client.setRoles(roles);
        transportOperatorRepository.save(client);
    }

    @Override
    public TransportOperator findByUsername(String telephone) {
        return transportOperatorRepository.findByTelephone(telephone);
    }

}
