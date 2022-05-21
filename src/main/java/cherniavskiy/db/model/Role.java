package cherniavskiy.db.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @JsonManagedReference
    @ManyToMany(mappedBy = "roles")
    private Set<Client> clients;

    public Role() {
    }

    public Role(Integer id, String name, Set<Client> clients) {
        this.id = id;
        this.roleName = name;
        this.clients = clients;
    }

    public Set<Client> getUsers() {
        return clients;
    }

    public void setUsers(Set<Client> clients) {
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
