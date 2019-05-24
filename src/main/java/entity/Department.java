package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    @JoinTable(
            name = "department_lectors",
            joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "lectors_id" )})
    private List<Lectors> lectors = new ArrayList<Lectors>();

    public Department() {
    }

    public Department(String name, List<Lectors> lectors) {
        this.name = name;
        this.lectors = lectors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLectors(List<Lectors> lectors) {
        this.lectors = lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
