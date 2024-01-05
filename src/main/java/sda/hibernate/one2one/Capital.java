package sda.hibernate.one2one;

import jakarta.persistence.*;

@Entity
@Table(name = "capitals")
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "capital", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Country country;

    public Capital(String name) {
        this.name = name;
    }

    public Capital() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
