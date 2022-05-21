package cherniavskiy.db.model;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {

    public City() {
    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_name")
    private String name;

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
}
