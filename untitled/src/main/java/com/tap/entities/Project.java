package com.tap.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "ID")
    private int id;
    @Column( name = "Name")
    private String name;
    @ManyToMany(cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "emp_project",
            joinColumns = @JoinColumn(name = "prg_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private List<Employee> employee;


    public int getId() {
        return id;
    }

    public Project(int id,String name) {
        this.name = name;
        this.id = id;
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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
