package cherniavskiy.db.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "Client")
public class Client {

    public Client() {
    }

    public Client(String name, String sname, String pname, String email, String telephone, String passhash, Integer fk_city_id) {
        this.name = name;
        this.sname = sname;
        this.pname = pname;
        this.email = email;
        this.telephone = telephone;
        this.passhash= passhash;
        this.fk_city_id = fk_city_id;
    }

    @Id
    @Column(name = "client_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_name", nullable = false)
    private String name;

    @Column(name = "client_sname", nullable = false)
    private String sname;

    @Column(name = "client_pname", nullable = false)
    private String pname;

    @Column(name = "client_email", nullable = false)
    private String email;

    @Column(name = "client_telephone", unique = true, nullable = false)
    private String telephone;

    @Column(name = "client_passhash", nullable = false)
    private String passhash;

    @Transient
    private String confirmPasshash;

    @Column(name = "fk_city_id", nullable = false)
    private Integer fk_city_id;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "client_role", joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> order;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    public String getConfirmPasshash() {
        return confirmPasshash;
    }

    public void setConfirmPasshash(String confirmPasshash) {
        this.confirmPasshash = confirmPasshash;
    }

    public Integer getFk_city_id() {
        return fk_city_id;
    }

    public void setFk_city_id(Integer fk_city_id) {
        this.fk_city_id = fk_city_id;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}