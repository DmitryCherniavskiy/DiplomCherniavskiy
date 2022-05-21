package cherniavskiy.db.model;

import javax.persistence.*;

@Entity
@Table(name = "Transport")
public class Transport {

    public Transport() {
    }

    public Transport(Integer id, String model, String transport_class, String description, String image, Integer year, Integer fk_to_id) {
        this.id = id;
        this.model = model;
        this.transport_class = transport_class;
        this.description = description;
        this.image = image;
        this.year = year;
        this.fk_to_id = fk_to_id;
    }


    @Id
    @Column(name = "transport_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transport_model")
    private String model;

    @Column(name = "transport_class")
    private String transport_class;

    @Column(name = "transport_description")
    private String description;

    @Column(name = "transport_image")
    private String image;

    @Column(name = "transport_year")
    private Integer year;

    @Column(name = "fk_to_id")
    private Integer fk_to_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransport_class() {
        return transport_class;
    }

    public void setTransport_class(String transport_class) {
        this.transport_class = transport_class;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getFk_to_id() {
        return fk_to_id;
    }

    public void setFk_to_id(Integer fk_to_id) {
        this.fk_to_id = fk_to_id;
    }
}