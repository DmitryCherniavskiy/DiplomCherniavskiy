package cherniavskiy.db.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "Transport_operator")
public class TransportOperator {

    public TransportOperator() {
    }

    public TransportOperator(Integer id, String name, String sname, String pname, String email, String telephone, String description, Double grade, Integer price_into, Integer price_between, Integer fk_city_id) {
        this.id = id;
        this.name = name;
        this.sname = sname;
        this.pname = pname;
        this.email = email;
        this.telephone = telephone;
        this.description = description;
        this.grade = grade;
        this.price_into = price_into;
        this.price_between = price_between;
        this.fk_city_id = fk_city_id;
    }

    public TransportOperator(String name, String sname, String pname, String email, String telephone, String passhash, Integer fk_city_id) {
        this.name = name;
        this.sname = sname;
        this.pname = pname;
        this.email = email;
        this.telephone = telephone;
        this.passhash= passhash;
        this.fk_city_id = fk_city_id;

    }

    @Id
    @Column(name = "to_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "to_name", nullable = false)
    private String name;

    @Column(name = "to_sname", nullable = false)
    private String sname;

    @Column(name = "to_pname")
    private String pname;

    @Column(name = "to_email", nullable = false)
    private String email;

    @Column(name = "to_telephone", nullable = false)
    private String telephone;

    @Column(name = "to_description")
    private String description;

    @Column(name = "to_grade")
    private Double grade;

    @Column(name = "to_price_into")
    private Integer price_into;

    @Column(name = "to_price_between")
    private Integer price_between;

    @Column(name = "fk_city_id", nullable = false)
    private Integer fk_city_id;

    @Column(name = "to_passhash", nullable = false)
    private String passhash;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "to", cascade = CascadeType.ALL)
    private List<Order> order;

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @ManyToMany
    @JoinTable(name = "to_role", joinColumns = @JoinColumn(name = "to_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getPrice_into() {
        return price_into;
    }

    public void setPrice_into(Integer price_into) {
        this.price_into = price_into;
    }

    public Integer getPrice_between() {
        return price_between;
    }

    public void setPrice_between(Integer price_between) {
        this.price_between = price_between;
    }

    public Integer getFk_city_id() {
        return fk_city_id;
    }

    public void setFk_city_id(Integer fk_city_id) {
        this.fk_city_id = fk_city_id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

}






