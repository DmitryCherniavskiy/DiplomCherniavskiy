package cherniavskiy.service;

import cherniavskiy.db.dao.ClientRepository;
import cherniavskiy.db.model.Client;
import cherniavskiy.db.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String telephone) throws UsernameNotFoundException {
        Client client = clientRepository.findByTelephone(telephone);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : client.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(client.getTelephone(), client.getPasshash(), grantedAuthorities);
    }

}