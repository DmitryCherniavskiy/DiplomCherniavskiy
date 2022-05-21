package cherniavskiy.service;


import cherniavskiy.db.dao.TransportOperatorRepository;
import cherniavskiy.db.model.Role;
import cherniavskiy.db.model.TransportOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class TODetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TransportOperatorRepository toRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String telephone) throws UsernameNotFoundException {
        TransportOperator to = toRepository.findByTelephone(telephone);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : to.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(to.getTelephone(), to.getPasshash(), grantedAuthorities);
    }

}
