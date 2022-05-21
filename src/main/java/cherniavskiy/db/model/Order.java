package cherniavskiy.db.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "Order")
public class Order {

    public Order() {
    }

    public Order(Integer id, Double grade, Double price, String start_place, String end_place, String date, String date_start, String date_end, Integer fk_to_id, Integer fk_client_id) {
        this.id = id;
        this.grade = grade;
        this.price = price;
        this.start_place = start_place;
        this.end_place = end_place;
        this.date = date;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_grade")
    private Double grade;

    @Column(name = "order_price")
    private Double price;

    @Column(name = "start_place")
    private String start_place;

    @Column(name = "end_place")
    private String end_place;

    @Column(name = "order_date")
    private String date;

    @Column(name = "date_start")
    private String date_start;

    @Column(name = "date_end")
    private String date_end;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="fk_client_id")
    private Client client;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_to_id")
    private TransportOperator to;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStart_place() {
        return start_place;
    }

    public void setStart_place(String start_place) {
        this.start_place = start_place;
    }

    public String getEnd_place() {
        return end_place;
    }

    public void setEnd_place(String end_place) {
        this.end_place = end_place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TransportOperator getTo() {
        return to;
    }

    public void setTo(TransportOperator to) {
        this.to = to;
    }
}