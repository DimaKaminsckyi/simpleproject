package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private Degree degree;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private int salary;

    @ManyToMany(mappedBy = "lectors")
    private List<Department> departments = new ArrayList<Department>();

    public Lectors() {
    }

    public Lectors(Degree degree, String fullName, int salary, List<Department> departments) {
        this.degree = degree;
        this.fullName = fullName;
        this.salary = salary;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lectors{" +
                "id=" + id +
                ", degree=" + degree +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
