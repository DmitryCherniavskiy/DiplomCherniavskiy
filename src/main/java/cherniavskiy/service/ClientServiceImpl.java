package cherniavskiy.service;

import cherniavskiy.db.dao.ClientRepository;
import cherniavskiy.db.dao.RoleDao;
import cherniavskiy.db.model.Client;
import cherniavskiy.db.model.Order;
import cherniavskiy.db.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Client client) {
        client.setPasshash(bCryptPasswordEncoder.encode(client.getPasshash()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1));
        client.setRoles(roles);
        clientRepository.save(client);
    }

    @Override
    public Client findByUsername(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }

    @Override
    public Iterable<Client> listAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        try {
            clientRepository.deleteById(id);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            //for the reason of idempotency leave this blank
        }
    }


    @Override
    public Client getById(Integer id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client getByTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }

    @Override
    public List<Order> getOrderByTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone).getOrder();
    }



}
