package cherniavskiy.db.dao;

import cherniavskiy.db.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByRoleName(String name);
}
